package lotto.domain;

import lotto.constant.Constant;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winning {
    private final List<Number> winNumbers = new ArrayList<>();

    public List<Number> createWinNumbers(String input) {
        String[] textWinNumbers = splitWinNumbers(input);
        checkWinNumbers(textWinNumbers);
        return parseWinNumbers(textWinNumbers);
    }

    private List<Number> parseWinNumbers(String[] textWinNumbers) {
        for (String textWinNumber : textWinNumbers) {
            winNumbers.add(new Number(parseInt(textWinNumber)));
        }
        return winNumbers;
    }

    private int parseInt(String textWinNumber) {
        return Integer.parseInt(textWinNumber);
    }

    private void checkWinNumbers(String[] textWinNumbers) {
        if (textWinNumbers.length != Constant.WINNING_SIZE) {
            throw new IllegalArgumentException("당첨번호 개수는 6개여야 합니다.");
        }
    }

    private String[] splitWinNumbers(String input) {
        return input.split(Constant.DELIMITER);
    }
}
