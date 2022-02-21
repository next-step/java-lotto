package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Lotto> add(final Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
        return this.lottos;
    }

    public int purchaseLottos(List<Lotto> lotto, Money money) {
        int numberOfLottoManual = lotto.size();
        LottoBundle lottoBundle = new LottoBundle(new ArrayList<>());
        lottos.addAll(lotto);
        int numberOfLottoAutomatical = calculateNumberOfLottosAutomatical(numberOfLottoManual,
            money);
        lottos.addAll(
            lottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));

        return numberOfLottoAutomatical;
    }

    public int calculateNumberOfLottosAutomatical(int numberOfLottoManual, Money money) {
        return calculateLotto(money) - numberOfLottoManual;
    }


    public int calculateLotto(Money money) {
        return money.getValue() / LOTTO_PRICE;
    }

}
