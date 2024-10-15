package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    private final List<LottoNumber> winningNumber = new ArrayList<>();

    public void convertStringToIntList(String stringWinningNumber) {
        Arrays.stream(splitString(stringWinningNumber))
                .map(Integer::parseInt)
                .map(LottoNumber::createLottoNumber)
                .forEach(winningNumber::add);
    }

    private String[] splitString(String stringWinningNumber) {
        return stringWinningNumber.split(", ");
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber;
    }

}
