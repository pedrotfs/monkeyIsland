package br.com.pedrotfs.MonkeyIsland.service.impl;

import br.com.pedrotfs.MonkeyIsland.util.MonkeyIslandTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultBananaFinderServiceTest {

    private DefaultBananaFinderService defaultBananaFinderService = new DefaultBananaFinderService();

    @Test
    void getMostBananas() {
        Integer bananas = defaultBananaFinderService.findMostBananas(MonkeyIslandTestUtils.buildInputMatrixOK());
        Assertions.assertEquals(bananas, 12);
    }

}