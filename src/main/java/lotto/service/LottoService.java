package lotto.service;

import lotto.domain.*;
import lotto.dto.LottoStatusResponseDto;
import lotto.util.LottoGenerator;
import lotto.util.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoService {

    private final Money money;
    private final Lottos lottos;

    public LottoService(Money money, Lottos lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static LottoService buyLotto(Money money) {
        return buyLotto(money, new RandomGenerator());
    }

    public static LottoService buyLotto(Money money, LottoGenerator lottoGenerator) {
        long countLotto = money.countLotto();
        List<Lotto> lottos = LongStream.range(0, countLotto)
                .mapToObj(l -> lottoGenerator.generateLotto())
                .collect(Collectors.toList());
        return new LottoService(money, new Lottos(lottos));
    }

    public LottoStatusResponseDto buyStatus() {
        return new LottoStatusResponseDto(lottos);
    }

    public LottoResults matchWinningLotto(WinningLotto winningNumbers) {
        return lottos.matchWinningLotto(winningNumbers);
    }

    public Profit profitRate(LottoResults lottoResults) {
        return new Profit(money, lottoResults.sumPrice());
    }
}
