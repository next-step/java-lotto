package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.dto.LottoCalculationDTO;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Lotto> add(final Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
        return this.lottos;
    }

    public LottoCalculationDTO purchaseLottos(List<Lotto> lotto, Money money) {
        int numberOfLottoManual = lotto.size();

        lottos.addAll(lotto);
        int numberOfLottoAutomatical = getNumberOfLottosAutomatical(numberOfLottoManual, money);
        lottos.addAll(
            LottoBundle.lottoBundle(numberOfLottoAutomatical, new ShuffleLottoNumber()));

        return new LottoCalculationDTO(numberOfLottoManual, numberOfLottoAutomatical,
            new Lottos(lottos));

    }

    int getNumberOfLottosAutomatical(int numberOfLottoManual, Money money) {
        return calculateLotto(money) - numberOfLottoManual;
    }

    public int calculateLotto(Money money) {
        return money.getValue() / LOTTO_PRICE;
    }

}
