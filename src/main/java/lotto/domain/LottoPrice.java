package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;

    private final LottoGenerator lottoGenerator;

    public LottoPrice(final LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buy(final int buyPrice) {
        return lottoGenerator.generate(toBuyCount(buyPrice));
    }

    public WinResult win(final List<Lotto> lottos, final List<Integer> winLottoNumbers) {
        return new WinResult(winJudge(lottos, Lotto.buy(winLottoNumbers)));
    }

    private int toBuyCount(final int buyPrice) {
        return buyPrice / LOTTO_PRICE;
    }

    private List<Rank> winJudge(final List<Lotto> lottos, final Lotto winLotto) {
        return lottos.stream()
                .map(lotto -> lotto.win(winLotto))
                .collect(Collectors.toList());
    }

}
