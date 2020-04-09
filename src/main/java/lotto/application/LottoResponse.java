package lotto.application;

import lotto.domain.lotto.Lotteries;
import lotto.domain.lotto.Lotto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoResponse {
    private final List<String> lottoResponse;

    public LottoResponse(Lotteries lotteries) {
        List<Lotto> lottery = lotteries.getLottery();
        this.lottoResponse = lottery.stream()
                .map(Lotto::toString)
                .collect(toList());
    }

}
