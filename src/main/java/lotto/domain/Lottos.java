package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.view.OutputView;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(LottoPrice lottoPrice) {
        validateLottoPrice(lottoPrice);
        this.lottos = generatorLottos(lottoPrice.getLottoCount());
    }

    private void validateLottoPrice(LottoPrice lottoPrice) {
        if (lottoPrice.isErrorOrNot()) {
            throw new IllegalArgumentException(OutputView.ERROR_WRONG_LOTTO_PRICE);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private List<Lotto> generatorLottos(int lottoCount) {
        List<Lotto> lottoLists = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoLists.add(LottoNumberGenerator.generate());
        }

        return lottoLists;
    }


}
