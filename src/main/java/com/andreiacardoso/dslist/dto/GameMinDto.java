package com.andreiacardoso.dslist.dto;

import com.andreiacardoso.dslist.entities.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameMinDto {

    private @Getter Long id;
    private @Getter String title;
    private @Getter Integer year;
    private @Getter String imgUrl;
    private @Getter String shortDescription;

    public GameMinDto(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }
}
