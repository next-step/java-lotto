package calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String userInput = inputView.getUserInput();

        InputParser inputParser = new InputParser();
        List<String> parsedNumbers = inputParser.parseInput(userInput);

    }
}
