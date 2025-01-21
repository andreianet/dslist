package com.andreiacardoso.dslist.controllers;

import com.andreiacardoso.dslist.dto.GameMinDto;
import com.andreiacardoso.dslist.entities.Game;
import com.andreiacardoso.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll() {
        List<GameMinDto> result = gameService.findAll();
        return result;
    }
}
