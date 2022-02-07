package br.com.pedrotfs.MonkeyIsland.service;

import java.util.List;

public interface InputHandlerService {

    List<List<Integer>> handleInput(String json) throws Exception;

}
