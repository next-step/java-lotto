package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Operand;
import enums.Operator;
import view.InputValidation;

public class InputValueParser {

    private String[] inputValues;
    private InputValidation inputValidation;

    public InputValueParser(String values) {
        this.inputValidation = new InputValidation();
        this.inputValues = inputValidation.validateNullAndEmpty(values).split(" ");
    }

    public List<Operator> parsingOperators() {
        return Arrays.stream(inputValues)
            .filter(Operator::isOperator)
            .map(Operator::findOperator)
            .collect(Collectors.toList());
    }

    public List<Operand> parsingOperands() {
        return Arrays.stream(inputValues)
            .filter(Operand::isOperand)
            .map(Operand::findOperand)
            .collect(Collectors.toList());
    }

}
