package com.andreiacardoso.dslist.dto;

import com.andreiacardoso.dslist.entities.GameList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameListDto {

    private @Getter  Long id;
    private @Getter String name;

    public GameListDto(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }
}
