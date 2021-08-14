package Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private List<Integer> winningNumbers;
    public static final String WINNINGNUMBERS_TEXT_SPLIT_REGEX = ",";
    public static final String WINNINGNUMBERS_TEXT_WHITE_SPACE = " ";

    public WinningNumber(String winningNumbers) {
        this.winningNumbers = convertInteger(convertLottoNumber(winningNumbers));
    }

    public static WinningNumber of(String winningNumbers) {
        return new WinningNumber(winningNumbers);
    }


    private List<Integer> convertInteger(String[] winningNumbers) {

        if (winningNumbers == null) {
            throw new IllegalArgumentException();
        }

        return Arrays.stream(winningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private String[] convertLottoNumber(String winningNumbers) {
        return winningNumbers.replace(WINNINGNUMBERS_TEXT_WHITE_SPACE, "").split(WINNINGNUMBERS_TEXT_SPLIT_REGEX);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(this.winningNumbers);
    }

    public int getSize() {
        return this.winningNumbers.size();
    }
}
