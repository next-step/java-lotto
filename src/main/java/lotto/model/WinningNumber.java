package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<LottoRank> match(Lottos tickets) {
        return tickets.tickets()
                .stream()
                .map(ticket -> this.match(ticket))
                .collect(Collectors.toList());
    }

    private LottoRank match(Lotto ticket) {
        return LottoRank.valueOf(
            ticket.numbers().matchNumbers(this.defaultNumbers),
            ticket.numbers().containsNumber(this.bonusNumber));
    }
}
