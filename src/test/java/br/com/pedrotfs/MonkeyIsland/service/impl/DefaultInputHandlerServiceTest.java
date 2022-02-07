package br.com.pedrotfs.MonkeyIsland.service.impl;

import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static br.com.pedrotfs.MonkeyIsland.util.MonkeyIslandTestUtils.*;

class DefaultInputHandlerServiceTest {

    private DefaultInputHandlerService inputHandlerService = new DefaultInputHandlerService();

    @Test
    void handleInput() throws Exception {
        inputHandlerService.setIdentifier("island");
        List<List<Integer>> matrixFromJson = inputHandlerService.handleInput(INPUT_OK);
        Assertions.assertEquals(matrixFromJson, buildInputMatrixOK());
    }

    @Test
    void handleInvalidInput() {
        inputHandlerService.setIdentifier("island");
        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            inputHandlerService.handleInput(INPUT_INVALID);
        });
    }

}