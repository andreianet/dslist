package com.andreiacardoso.dslist.services;

import com.andreiacardoso.dslist.dto.GameDto;
import com.andreiacardoso.dslist.dto.GameListDto;
import com.andreiacardoso.dslist.dto.GameMinDto;
import com.andreiacardoso.dslist.entities.Game;
import com.andreiacardoso.dslist.entities.GameList;
import com.andreiacardoso.dslist.projections.GameMinProjection;
import com.andreiacardoso.dslist.repositories.GameListRepository;
import com.andreiacardoso.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
