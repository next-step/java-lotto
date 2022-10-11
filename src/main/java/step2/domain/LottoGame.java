package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoGame() {
    }

    public static LottoGame newInstance() {
        return new LottoGame();
    }

    public int makeLottoTicket(int price) {
        return price / LOTTO_TICKET_PRICE;
    }

    public List<LottoNumber> playLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            lottoNumbers.add(LottoNumber.newInstance());
        }

        return lottoNumbers;
    }
}
