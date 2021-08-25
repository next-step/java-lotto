package lotto.domain;

import java.util.Set;
import java.util.TreeSet;

public class WinningLottoNumber {

    public static final int MIN_NUMBER_BOUND = 1;
    public static final int MAX_NUMBER_BOUND = 45;
    public static final int LOTTO_NUMBER_SIZE = 6;
    private Set<Integer> winningNumber = new TreeSet<>();

    public Set<Integer> getWinningNumber() {
        return winningNumber;
    }

    public void setWinningNumber(String winningNumbers) {
        String[] numbers = winningNumbers.split(",");

        if (numbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자는 총 6개여야 합니다.");
        }

        for (String number : numbers) {
            winningNumber.add(checkWinningNumber(number));
        }

        if (winningNumber.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    private int checkWinningNumber(String numberStr) {
        int winningNumber = Integer.parseInt(numberStr);

        if (winningNumber < MIN_NUMBER_BOUND || winningNumber > MAX_NUMBER_BOUND) {
            throw new IllegalArgumentException("숫자는 1이상 45이하여야 합니다.");
        }

        return winningNumber;
    }

}
