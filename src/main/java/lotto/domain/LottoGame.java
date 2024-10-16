package lotto.domain;

import lotto.dto.WinningResult;
import lotto.strategy.LottoGenerator;

import java.util.*;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoGame(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> create(final String money) {
        int count = Integer.parseInt(money) / LOTTO_PRICE;
        return lottoGenerator.generate(count);
    }

    public WinningResult match(final List<Lotto> lottos, final String winningNumber) {
        Match match = new Match(lottos, winningNumber);
        Winnings winnings = match.winnings();
        return winnings.result(lottos);
    }
}
