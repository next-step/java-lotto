package step1.controller;

import step1.InputNumber;
import step1.Inputs;

public class CalculateProcessor {
    public InputNumber calculate(Inputs inputs) {
        return inputs.sum();
    }
}
