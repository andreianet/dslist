package com.andreiacardoso.dslist.repositories;

import com.andreiacardoso.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
