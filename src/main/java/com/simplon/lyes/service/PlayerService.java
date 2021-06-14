package com.simplon.lyes.service;

import com.simplon.lyes.repository.JsonRepository;

public class PlayerService {

    JsonRepository jsonRepository;

    public PlayerService(){
        jsonRepository = new JsonRepository("Saved Games");
    }
}
