package com.andreiacardoso.dslist.services;

import com.andreiacardoso.dslist.dto.GameDto;
import com.andreiacardoso.dslist.dto.GameMinDto;
import com.andreiacardoso.dslist.entities.Game;
import com.andreiacardoso.dslist.projections.GameMinProjection;
import com.andreiacardoso.dslist.repositories.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        if (id == null || id <= 0){
            throw new IllegalArgumentException("Id invalid");
        }
            Game result = gameRepository.findById(id).get();
            return new GameDto(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDto(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDto(x)).toList();
    }
}
