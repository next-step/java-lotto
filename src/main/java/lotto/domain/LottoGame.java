package lotto.domain;

import java.util.*;

public class LottoGame {
    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;
    private final LottoResult lottoResult;

    public LottoGame(int money, LottoGenerator lottoGenerator, String winningNumber) {
        this.lottos = lottoGenerator.generate(money);
        this.winningNumber = new WinningNumber(Parser.parse(winningNumber));
        this.lottoResult = new LottoResult(lottos, this.winningNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }
}
