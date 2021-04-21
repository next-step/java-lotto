package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinNumbers {

    private List<Integer> winNumbers;

    public WinNumbers(String numbers){
        String[] stringWinNumber = numbers.split(",");
        validateWinNumbers(stringWinNumber);

        this.winNumbers =  Arrays.stream(stringWinNumber)
                .map(num -> num.trim())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateWinNumbers(String[] stringWinNumber) {
        if ( stringWinNumber.length != 6) {
            throw new IllegalStateException("로또의 숫자는 6자리여야 합니다");
        }
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }
}
