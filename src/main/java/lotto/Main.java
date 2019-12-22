package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;

import java.util.List;

import static lotto.io.InputView.getOrder;

public class Main {

    public static void main(String[] args) {

        List<Lotto> list = LottoShop.order(getOrder());
    }
}
