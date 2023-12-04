package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

    public Map<LottoRank, Long> match(Lottos tickets) {
        return tickets.tickets().stream()
                .map(ticket -> this.match(ticket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private LottoRank match(Lotto ticket) {
        LottoCondition condition = LottoCondition.valueOf(
                ticket.numbers().matchNumbers(this.defaultNumbers),
                ticket.numbers().containsNumber(this.bonusNumber));
        return LottoRank.getByCondition(condition);
    }
}
