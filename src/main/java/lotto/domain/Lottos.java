package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.exception.LottoNumberException;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    public static final String ERR_MESSAGE_NUMBER_FORMAT = "숫자형식 입력값이 아닙니다.";
    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public static int getCount(String price) {
        try {
            int lottoPrice = Integer.parseInt(price);
            return lottoPrice / LOTTO_PRICE;
        } catch (NumberFormatException e) {
            throw new LottoNumberException(ERR_MESSAGE_NUMBER_FORMAT);
        }
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
