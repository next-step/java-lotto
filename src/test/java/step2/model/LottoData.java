package step2.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoData {

    public static MatchResult createMatchResult(LottoRank lottoRank, int matchCount) {
        MatchResult matchResult = MatchResult.create();

        IntStream.range(0, matchCount).forEach(i -> {
            matchResult.plusCount(lottoRank);
        });

        return matchResult;
    }

    public static List<Lotto> createLottoTickets(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(i -> createLottoNumbers(6))
                .map(Lotto::create)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> createLottoNumbers(int count) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public static MoneyAmount createMoneyAmount(int amount) {
        return MoneyAmount.create(Money.valueOf(amount));
    }
}
