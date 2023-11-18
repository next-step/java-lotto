package calculator;

import java.util.Scanner;

public class CalculatorController {

    private final Calculator calculator;
    private final CharacterParser characterParser;

    public CalculatorController(Calculator calculator, CharacterParser characterParser) {
        this.calculator = calculator;
        this.characterParser = characterParser;
    }

    public int calculatingValue(String expression) {
        characterParser.parsingFormula(expression);
        return calculator.calc(characterParser.operands(), characterParser.operators());
    }
}
