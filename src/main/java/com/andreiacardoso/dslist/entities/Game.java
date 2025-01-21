package com.andreiacardoso.dslist.entities;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_Game")
public class Game {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    @Column(name = "game_year")
    private Integer year;
    @Getter
    @Setter
    private String genre;
    @Getter
    @Setter
    private String platforms;
    @Getter
    @Setter
    private Double score;
    @Getter
    @Setter
    private String imgUrl;
    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String shortDescription;
    @Getter
    @Setter
    @Column(columnDefinition = "TEXT")
    private String longDescription;



}
