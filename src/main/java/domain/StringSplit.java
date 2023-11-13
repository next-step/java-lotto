package domain;

import ui.InputView;

import java.util.Arrays;
import java.util.List;

public class StringSplit {
    private String calculatorInput;

    public StringSplit(String calculatorInput) {
        this.calculatorInput = calculatorInput;
    }

    public List<String> split(){
        return Arrays.asList(calculatorInput.split(" "));
    }
}
