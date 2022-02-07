package br.com.pedrotfs.MonkeyIsland.service.impl;

import br.com.pedrotfs.MonkeyIsland.service.BananaFinderService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultBananaFinderService implements BananaFinderService {

    @Override
    public int findMostBananas(List<List<Integer>> forest) {
        int result = 0;
        int positionVertical = -1;
        int maxCurrentRow = 0;
        int verticalSize = 0;
        if(verticalSize == 0) {
            verticalSize = forest.get(0).size();
        }
        for(int i = 0; i < forest.size(); i++) {
            if(positionVertical < 0) { //first row

                for(int j = 0; j < verticalSize; j++) {
                    Integer element = forest.get(j).get(i);
                    if(element > maxCurrentRow) {
                        maxCurrentRow = element;
                        positionVertical = j;
                    }
                }
            } else { //other rows
                int elementAbove = 0;
                int element = forest.get(i).get(positionVertical);
                int elementBelow = 0;

                if(positionVertical > 0) {
                    elementAbove = forest.get(i).get(positionVertical - 1);
                }
                if(positionVertical < forest.size() - 1) {
                    elementBelow = forest.get(i).get(positionVertical + 1);
                }

                if(elementAbove >= element && elementAbove >= elementBelow) {
                    maxCurrentRow = elementAbove;
                    positionVertical = positionVertical - 1;

                }

                if(element >= elementAbove && element >= elementBelow) {
                    maxCurrentRow = elementAbove;
                }

                if(elementBelow >= element && elementBelow >= elementAbove) {
                    maxCurrentRow = elementBelow;
                    positionVertical = positionVertical + 1;
                }

            }
            result = result + maxCurrentRow;
            maxCurrentRow = 0;
        }


        return result;
    }
}
