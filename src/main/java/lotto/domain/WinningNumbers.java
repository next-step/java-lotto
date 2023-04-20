package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(String numbers) {
        final List<LottoNumber> winningNumbers = new ArrayList<>();

        for (String number : numbers.replaceAll(" ", "").split(",")) {
            winningNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }

        this.winningNumbers = winningNumbers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
