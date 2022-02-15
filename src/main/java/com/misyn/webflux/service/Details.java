package com.misyn.webflux.service;

import lombok.Data;

@Data
public class Details {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
