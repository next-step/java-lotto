package step1.service;

import step1.domain.Calculator;
import step1.domain.Parser;
import step1.domain.Validator;

public class CalculatorService {

    private final Calculator calculator = new Calculator();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();

    public int calculate(String userInput) {
        if (!validator.isInputMadeOfValidElements(userInput)) throw new IllegalArgumentException();
        return calculator.addBulk(parser.parse(userInput));
    }


}
