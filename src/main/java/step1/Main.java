package step1;

import step1.domain.Calculator;
import step1.view.Input;
import step1.view.Output;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Output.output(Input.input());
    }
}
