package com.andreiacardoso.dslist.dto;

import com.andreiacardoso.dslist.entities.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
public class GameDto {

    private @Getter @Setter Long id;
    private @Getter @Setter String title;
    private @Getter @Setter Integer year;
    private @Getter @Setter String genre;
    private @Getter @Setter Double score;
    private @Getter @Setter String imgUrl;
    private @Getter @Setter String shortDescription;
    private @Getter @Setter String longDescription;

    public GameDto(Game entity) {
        BeanUtils.copyProperties(entity, this);
    }

}
