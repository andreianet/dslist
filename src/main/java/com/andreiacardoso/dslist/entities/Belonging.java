package com.andreiacardoso.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private @Getter @Setter BelongingPK id = new BelongingPK();
    private @Getter @Setter Integer position;

    public Belonging(Game game, GameList list,Integer position) {
        id.setList(list);
        id.setGame(game);
        this.position = position;
    }

}
