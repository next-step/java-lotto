package step1;

import step1.domain.StringAddCalculator;
import step1.view.Input;
import step1.view.Output;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Integer result = StringAddCalculator.splitAndSum(input.getStringInput());
        Output.output(result);
    }
}
