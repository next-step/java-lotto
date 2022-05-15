package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(String[] winningNumber, int bonusNumber) {
        this.winningNumbers = parseStringArrayToLotto(winningNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumbers = parseIntegerListToLotto(winningNumber);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public List<LottoNumber> winningNumbers() {
        return Collections.unmodifiableList(winningNumbers.lottoNumbers());
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    private Lotto parseStringArrayToLotto(String[] strings) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (String string : strings) {
            winningNumbers.add(LottoNumber.of(string));
        }

        return new Lotto(winningNumbers);
    }

    private Lotto parseIntegerListToLotto(List<Integer> numbers) {
        List<LottoNumber> winningNumbers = new ArrayList<>();
        for (int number : numbers) {
            winningNumbers.add(LottoNumber.of(number));
        }

        return new Lotto(winningNumbers);
    }
}
