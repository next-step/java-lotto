package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPrice {

    public static final int LOTTO_PRICE = 1000;

    private LottoPrice() {
    }

    public static List<Lotto> buy(final LottoGenerator lottoGenerator, final int buyPrice) {
        return lottoGenerator.generate(toBuyCount(buyPrice));
    }

    public static WinResult win(final List<Lotto> lottos, final List<Integer> winLottoNumbers, final int bonusNumber) {
        return new WinResult(winJudge(lottos, Lotto.buy(winLottoNumbers), new LottoNumber(bonusNumber)));
    }

    private static int toBuyCount(final int buyPrice) {
        return buyPrice / LOTTO_PRICE;
    }

    private static List<Rank> winJudge(final List<Lotto> lottos, final Lotto winLotto, final LottoNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.win(winLotto, bonusNumber))
                .collect(Collectors.toList());
    }

}
