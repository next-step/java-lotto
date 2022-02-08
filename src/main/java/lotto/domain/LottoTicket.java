package lotto.domain;

import static lotto.view.OutputView.ERROR_WRONG_LOTTO_PRICE;

import java.util.ArrayList;
import lotto.domain.LottoTicketGenerator;

import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private static final int LOTTO_PRICE = 1000;

    final List<Lotto> lottoTicket;
    final int lottoCount;

    public LottoTicket(int totalPrice) {
        validateLottoPrice(totalPrice);

        this.lottoCount = totalPrice / LOTTO_PRICE;
        this.lottoTicket = LottoTicketGenerator.from(lottoCount).getLottoTicket();
    }

    public List<Lotto> getLottoLists() {
        return Collections.unmodifiableList(lottoTicket);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    private void validateLottoPrice(int totalPrice) {
        if (totalPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_WRONG_LOTTO_PRICE);
        }
    }

}
