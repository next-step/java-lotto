package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    private List<Integer> lotto;

    public LottoNumber() {
        lotto = new ArrayList<>();
    }

    public void setAutoNumber(RandomNumber lottoNumberStragey) {
        lotto = lottoNumberStragey.getLottoNumber();
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public void setWinningNumber(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");

        if (numbers.length != 6) {
            throw new IllegalArgumentException("숫자는 총 6개여야 합니다.");
        }

        for(int count = 0; count < numbers.length; count++) {
            int winningNumber = checkWinningNumber(numbers[count]);
            lotto.add(winningNumber);
        }

        Collections.sort(lotto);
    }

    private int checkWinningNumber(String numberStr) {
        int winningNumber = Integer.parseInt(numberStr);

        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("숫자는 1이상 45이하여야 합니다.");
        }

        return winningNumber;
    }

}
