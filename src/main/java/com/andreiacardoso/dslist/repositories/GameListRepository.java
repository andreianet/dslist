package com.andreiacardoso.dslist.repositories;

import com.andreiacardoso.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
