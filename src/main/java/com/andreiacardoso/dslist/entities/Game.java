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
    private String platform;
    @Getter
    @Setter
    private String imgUrl;
    @Getter
    @Setter
    private String shortDescription;
    @Getter
    @Setter
    private String longDescription;



}
