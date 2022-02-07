package br.com.pedrotfs.MonkeyIsland.service.impl;

import br.com.pedrotfs.MonkeyIsland.service.InputHandlerService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultInputHandlerService implements InputHandlerService {

    private Gson gson = new Gson();

    private String identifier;

    @Override
    public List<List<Integer>> handleInput(String json) throws Exception {
        JsonElement jsonElement = gson.fromJson(json, JsonElement.class);
        JsonArray jsonArray = (JsonArray) jsonElement.getAsJsonObject().get(identifier);
        return assembleForest(jsonArray);
    }

    private List<List<Integer>> assembleForest(JsonArray jsonArray) throws Exception {
        final List<List<Integer>> forest = new ArrayList<>();
        jsonArray.forEach(b -> {
            JsonArray sublist = b.getAsJsonArray();
            List<Integer> line = new ArrayList<>();
            for(int i = 0; i < sublist.size(); i++) {
                line.add(sublist.get(i).getAsInt());
            }
            forest.add(line);
        });
        if(! validateDimensions(forest)) {
            throw new Exception("dimensions do not respect n x m size. not all lines have an n size or ");
        }
        return forest;
    }

    private boolean validateDimensions(List<List<Integer>> matrix) {
        int size = -1;
        for(List<Integer> list : matrix) {
            if(size == -1) {
                size = list.size();
            }
            if(size != list.size()) {
                return false;
            }
        }
        return true;
    }



    @Value("${monkeyIsland.identifier}")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
