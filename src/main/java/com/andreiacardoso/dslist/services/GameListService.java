package com.andreiacardoso.dslist.services;

import com.andreiacardoso.dslist.dto.GameDto;
import com.andreiacardoso.dslist.dto.GameListDto;
import com.andreiacardoso.dslist.dto.GameMinDto;
import com.andreiacardoso.dslist.entities.Game;
import com.andreiacardoso.dslist.entities.GameList;
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

    public List<GameListDto> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDto(x)).toList();
    }
}
