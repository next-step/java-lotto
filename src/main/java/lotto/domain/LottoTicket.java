package lotto.domain;

import static lotto.view.OutputView.ERROR_WRONG_LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1000;

    final List<Lotto> lottoLists;
    final int lottoCount;

    public LottoTicket(int totalPrice) {
        validateLottoPrice(totalPrice);

        this.lottoCount = totalPrice / LOTTO_PRICE;
        this.lottoLists = generatorLottos();
    }

    public List<Lotto> getLottoLists() {
        return Collections.unmodifiableList(lottoLists);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private List<Lotto> generatorLottos() {
        List<Lotto> lottoLists = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottoLists.add(new Lotto());
        }

        return lottoLists;
    }

    private void validateLottoPrice(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_PRICE);
        }
    }

}
