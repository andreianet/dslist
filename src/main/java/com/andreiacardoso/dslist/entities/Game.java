package com.andreiacardoso.dslist.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_Game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String title;
    @Column(name = "game_year")
    private @Getter  @Setter  Integer year;
    private @Getter @Setter String genre;
    private @Getter @Setter String platforms;
    private @Getter @Setter Double score;
    private @Getter @Setter String imgUrl;
    @Column(columnDefinition = "TEXT")
    private @Getter @Setter String shortDescription;
    @Column(columnDefinition = "TEXT")
    private @Getter @Setter String longDescription;

}
