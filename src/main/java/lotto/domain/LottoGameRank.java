package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public enum LottoGameRank {
    FIRST(new Money(2_000_000_000), count -> count == 6),
    SECOND(new Money(1_500_000), count -> count == 5),
    THIRD(new Money(50_000), count -> count == 4),
    FOURTH(new Money(5_000), count -> count == 3),
    NONE(new Money(0), count -> false);

    private final Money price;
    private final Function<Long, Boolean> rankCondition;

    LottoGameRank(Money price, Function<Long, Boolean> rankCondition) {
        this.price = price;
        this.rankCondition = rankCondition;
    }

    public static LottoGameRank findRank(LottoTicket lottoTicket, LottoResult lottoResult) {
        long count = countSameNumbers(lottoTicket.getLottoNumbers(), lottoResult.getLottoNumbers());

        return Arrays.stream(values())
            .filter(rank -> rank.rankCondition.apply(count))
            .findFirst()
            .orElse(LottoGameRank.NONE);
    }

    private static long countSameNumbers(List<LottoNumber> lottoNumbers, List<LottoNumber> resultNumbers) {
        return resultNumbers.stream()
            .filter(lottoNumbers::contains)
            .count();
    }

    public Money getPrice() {
        return price;
    }
}
