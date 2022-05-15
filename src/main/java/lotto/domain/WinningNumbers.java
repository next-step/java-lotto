package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String[] winningNumber, int bonusNumber) {
        this.winningNumbers = parseStringWinningNumbers(winningNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumbers = parseIntegerWinningNumbers(winningNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public List<LottoNumber> winningNumbers() {
        return Collections.unmodifiableList(winningNumbers.lottoNumbers());
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    private Lotto parseStringWinningNumbers(String[] strings) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String string : strings) {
            winningNumbers.add(new LottoNumber(string));
        }

        return new Lotto(winningNumbers);
    }

    private Lotto parseIntegerWinningNumbers(List<Integer> numbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (int number : numbers) {
            winningNumbers.add(new LottoNumber(number));
        }

        return new Lotto(winningNumbers);
    }
}
