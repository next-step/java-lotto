package step2.domain;

import step2.util.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottery {
    
    private Lottery winningLottery;

    public WinningLottery(String[] winningNumbers) {
        if (winningNumbers.length != Constants.WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException(Constants.WINNING_NUMBER_MUST_BE_6);
        }
        winningLottery = new Lottery(convertToInteger(winningNumbers));
    }

    private List<Integer> convertToInteger(String[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                    .map(this::convertNumber)
                    .collect(Collectors.toList());
    }

    private int convertNumber(String number) {
        int convertedNumber = Integer.parseInt(number);

        if (convertedNumber >= 1 && convertedNumber <= 45) {
            throw new IllegalArgumentException(Constants.WINNING_NUMBER_INVALID_RANGE);
        }
        return convertedNumber;
    }
}
