package lotto.strategy;

import lotto.service.LottoNumbers;

public interface LotteryStrategy {
    public LottoNumbers draw(LottoNumbers numbers);
}
