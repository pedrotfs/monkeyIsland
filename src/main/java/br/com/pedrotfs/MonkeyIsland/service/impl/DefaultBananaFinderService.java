package br.com.pedrotfs.MonkeyIsland.service.impl;

import br.com.pedrotfs.MonkeyIsland.service.BananaFinderService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultBananaFinderService implements BananaFinderService {

    @Override
    public int findMostBananas(List<List<Integer>> forest) {
        int result = 0;
        int maxResult = 0;
        int horizontalSize = forest.get(0).size(); //this was validated to not change on input

        for(int vertical = 0; vertical < forest.size(); vertical++) { //starting at each vertical position
            int currentVertical = vertical;

            for(int horizontalPosition = 0; horizontalPosition < horizontalSize; horizontalPosition++) { //them going to the right to look for the highest sum
                result = result + forest.get(currentVertical).get(horizontalPosition);

                if(horizontalPosition < horizontalSize - 1) { //not at the rightmost, so must have elements to the right
                    int rightElement = forest.get(currentVertical).get(horizontalPosition + 1);
                    int rightUpElement = 0;
                    if(currentVertical > 0) { //not at the top, so must have elements above
                        rightUpElement = forest.get(currentVertical - 1).get(horizontalPosition + 1);
                    }
                    int rightDownElement = 0;
                    if(currentVertical < forest.size() - 1) { //not at the botton, so must have elements bellow
                        rightDownElement = forest.get(currentVertical + 1).get(horizontalPosition + 1);
                    }

                    //determining next move by max bananas
                    int maxAmount = Math.max(rightElement, rightUpElement);
                    maxAmount = Math.max(maxAmount, rightDownElement);

                    if(maxAmount == rightUpElement) {
                        currentVertical--;
                    } else if(maxAmount == rightDownElement){
                        currentVertical++;
                    }

                }
            }

            if(maxResult < result) { //getting maximum result by starting vertical
                maxResult = result;
            }
            result = 0;

        }
        return maxResult;
    }
}
