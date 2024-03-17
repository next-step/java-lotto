package view;


import model.NumberSentence;
import model.Validator;

import java.util.Scanner;

public class InputView {

    private final Validator validator;
    private static final String SEPARATOR = " ";


    Scanner scanner = new Scanner(System.in);

    public InputView(Validator validator) {
        this.validator = validator;
    }

    public String input() {
        return scanner.nextLine();
    }

    public NumberSentence inputNumberSentence() {
        String numberSentence = input();
        validator.nullCheck(numberSentence);

        String[] numberSentences = numberSentence.split(SEPARATOR);
        validator.validate(numberSentences);

        return new NumberSentence(numberSentences);
    }
}
