package kr.heesu.calculator.view;

import kr.heesu.calculator.domain.Result;

import java.io.PrintWriter;

public class ResultView {
    private final PrintWriter writer;
    private ResultView() {
        this.writer = new PrintWriter(System.out, true);
    }

    public void printResult(Result result) {
        writer.println(result);
    }

    public static ResultView of() {
        return new ResultView();
    }
}
