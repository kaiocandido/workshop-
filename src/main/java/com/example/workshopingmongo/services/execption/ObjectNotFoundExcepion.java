package com.example.workshopingmongo.services.execption;

import java.io.Serial;

public class ObjectNotFoundExcepion extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundExcepion(String msg){
        super(msg);
    }
}
