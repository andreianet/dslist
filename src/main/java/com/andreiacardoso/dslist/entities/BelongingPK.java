package com.andreiacardoso.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable //to encapsulate two attributes in a class
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "list_id")
    private @Getter @Setter GameList list;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private @Getter @Setter Game game;
}
