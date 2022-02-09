package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {

    private final LottoNumber number;
    private final boolean isBonus;

    public WinningNumber(int number) {
        this(number, false);
    }

    public WinningNumber(String number) {
        this(Integer.parseInt(number), false);
    }

    public WinningNumber(String number, boolean isBonus) {
        this(Integer.parseInt(number), isBonus);
    }

    public WinningNumber(int number, boolean isBonus) {
        this.number = new LottoNumber(number);
        this.isBonus = isBonus;
    }

    public static List<WinningNumber> getWinningNumbers(String[] numbers, String bonusNumber) {
        List<WinningNumber> winningNumbers = Arrays.stream(numbers)
            .map(WinningNumber::new)
            .collect(Collectors.toList());

        winningNumbers.add(new WinningNumber(bonusNumber, true));
        return winningNumbers;
    }

    public int getNumber() {
        return number.getNumber();
    }

    public boolean isBonus() {
        return isBonus;
    }
}
