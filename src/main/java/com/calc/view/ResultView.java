package com.calc.view;

public class ResultView {

    private int result;

    public ResultView(int result) {
        this.result = result;
    }

    public void print() {
        System.out.println(this.result);
    }
}
