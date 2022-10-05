package step1.application;

import step1.domain.Number;

public class OutputView {

    private final Number number;

    public OutputView(Number number) {
        this.number = number;
    }

    public void result() {
        System.out.println("결과: " + number.getNumber());
    }

}
