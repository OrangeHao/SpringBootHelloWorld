package com.example.helloworld.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Money {
    private int basic;
    private int reward;
    private int punishment;
}
