package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoCollection {
    private static final int ONE_LOTTO_COST = 1000;

    private final List<Lotto> lottos;
    private final int buyAmount;

    public LottoCollection(int buyAmount, LottoNumbersGenerator lottoNumbersGenerator) {
        this.buyAmount = buyAmount;
        int lottoCount = convertLottoCount(buyAmount);

        lottos = IntStream
                .range(0, lottoCount)
                .mapToObj(i -> new Lotto(lottoNumbersGenerator.generate()))
                .collect(Collectors.toList());
    }

    public LottoResult getLottoResult(Lotto winnerLotto, LottoNumber bonusNumber) {
        return new LottoResult(lottos, winnerLotto, bonusNumber, buyAmount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static int convertLottoCount(int buyAmount) {
        return buyAmount / ONE_LOTTO_COST;
    }
}
