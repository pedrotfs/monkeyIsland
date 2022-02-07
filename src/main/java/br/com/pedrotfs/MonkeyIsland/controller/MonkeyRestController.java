package br.com.pedrotfs.MonkeyIsland.controller;

import br.com.pedrotfs.MonkeyIsland.service.BananaFinderService;
import br.com.pedrotfs.MonkeyIsland.service.InputHandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monkeyIsland")
public class MonkeyRestController {

    private Logger LOG = LoggerFactory.getLogger(MonkeyRestController.class);

    @Autowired
    private InputHandlerService inputHandlerService;

    @Autowired
    private BananaFinderService bananaFinderService;

    @PostMapping("/")
    public ResponseEntity<String> bid(@RequestBody final String island) {
        LOG.info("receiving request body: " + island);
        try {
            List<List<Integer>> forest = inputHandlerService.handleInput(island);
            return new ResponseEntity<>("output: " + bananaFinderService.findMostBananas(forest), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>("Malformed Input Json.", HttpStatus.BAD_REQUEST);
        }
    }

}
