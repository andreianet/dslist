package com.andreiacardoso.dslist.services;

import com.andreiacardoso.dslist.dto.GameDto;
import com.andreiacardoso.dslist.dto.GameMinDto;
import com.andreiacardoso.dslist.entities.Game;
import com.andreiacardoso.dslist.projections.GameMinProjection;
import com.andreiacardoso.dslist.repositories.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Game game;
    private GameMinProjection gameMinProjection;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.setId(1L);
        game.setTitle("Test Game");

        gameMinProjection = mock(GameMinProjection.class);
        when(gameMinProjection.getId()).thenReturn(1L);
        when(gameMinProjection.getTitle()).thenReturn("Test Game");
    }

    @Test
    void testFindById() {
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));

        GameDto gameDto = gameService.findById(1L);

        assertNotNull(gameDto);
        assertEquals(game.getId(), gameDto.getId());
        assertEquals(game.getTitle(), gameDto.getTitle());

        verify(gameRepository, times(1)).findById(1L);
    }

    @Test
    void testFindByIdInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> gameService.findById(0L));
        assertThrows(IllegalArgumentException.class, () -> gameService.findById(null));
    }

    @Test
    void testFindAll() {
        when(gameRepository.findAll()).thenReturn(List.of(game));

        List<GameMinDto> games = gameService.findAll();

        assertNotNull(games);
        assertEquals(1, games.size());
        assertEquals(game.getId(), games.get(0).getId());
        assertEquals(game.getTitle(), games.get(0).getTitle());

        verify(gameRepository, times(1)).findAll();
    }

    @Test
    void testFindByList() {
        when(gameRepository.searchByList(1L)).thenReturn(List.of(gameMinProjection));

        List<GameMinDto> games = gameService.findByList(1L);

        assertNotNull(games);
        assertEquals(1, games.size());
        assertEquals(gameMinProjection.getId(), games.get(0).getId());
        assertEquals(gameMinProjection.getTitle(), games.get(0).getTitle());

        verify(gameRepository, times(1)).searchByList(1L);
    }
}