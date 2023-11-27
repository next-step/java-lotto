package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final LottoNumbers defaultNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(LottoNumbers numbers, LottoNumber bonusNumber) {
        this.defaultNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this(LottoNumbers.of(numbers), new LottoNumber(bonusNumber));
    }

    public LottoRank match(Lotto ticket) {
        return LottoRank.valueOf(
            ticket.numbers().matchNumbers(this.defaultNumbers),
            ticket.numbers().containsNumber(this.bonusNumber));
    }
}
