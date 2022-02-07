package br.com.pedrotfs.MonkeyIsland.controller;

import br.com.pedrotfs.MonkeyIsland.service.BananaFinderService;
import br.com.pedrotfs.MonkeyIsland.service.InputHandlerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static br.com.pedrotfs.MonkeyIsland.util.MonkeyIslandTestUtils.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class MonkeyRestControllerTest {

    @InjectMocks
    private MonkeyRestController monkeyRestController;

    @Mock
    private InputHandlerService inputHandlerService;

    @Mock
    private BananaFinderService bananaFinderService;

    private final List<List<Integer>> inputMatrixOK = buildInputMatrixOK();

    private final List<List<Integer>> inputMatrixNOK = buildInputMatrixNOK();

    @Test
    void getBananas() throws Exception {
        doReturn(inputMatrixOK).when(inputHandlerService).handleInput(INPUT_OK);
        doReturn(12).when(bananaFinderService).findMostBananas(buildInputMatrixOK());

        ResponseEntity<String> mostBananas = monkeyRestController.findMostBananas(INPUT_OK);
        Assertions.assertEquals(mostBananas.getBody(), "output: 12");
        Assertions.assertEquals(mostBananas.getStatusCodeValue(), 200);
    }

    @Test
    void getBananasBadInput() throws Exception {
        doReturn(inputMatrixNOK).when(inputHandlerService).handleInput(INPUT_NOK);
        doThrow(new NumberFormatException("Malformed Input Json.")).when(bananaFinderService).findMostBananas(buildInputMatrixNOK());


        ResponseEntity<String> mostBananas = monkeyRestController.findMostBananas(INPUT_NOK);
        Assertions.assertEquals(mostBananas.getBody(), "Malformed Input Json.");
        Assertions.assertEquals(mostBananas.getStatusCodeValue(), 400);

    }

}