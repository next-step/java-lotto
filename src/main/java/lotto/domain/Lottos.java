package lotto.domain;

import static lotto.view.OutputView.ERROR_WRONG_LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    List<List<LottoNumber>> lottoLists;
    final int lottoCount;

    public Lottos(int totalPrice) {
        validateLottoPrice(totalPrice);

        this.lottoCount = totalPrice / LOTTO_PRICE;
        this.lottoLists = generatorLottos();
    }

    public List<List<LottoNumber>> getLottoLists() {
        return Collections.unmodifiableList(lottoLists);
    }

    private List<List<LottoNumber>> generatorLottos() {
        List<List<LottoNumber>> lottoLists = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<LottoNumber> lottoNumberList = lottoNumberGenerator.generate();
            lottoLists.add(lottoNumberList);
        }

        return lottoLists;
    }

    private void validateLottoPrice(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_PRICE);
        }
    }
    public int getLottoCount() {
        return lottoCount;
    }
}
