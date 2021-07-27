package lotto.controller;

import static lotto.common.Properties.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.view.InputView;

public class LottoMachineController {

    public static void main(String[] args) {
        List<Lotto> purchasedLottos = createPurchasedLottos();
        Lotto winningLotto = createWinningLotto(InputView.inputWinningNumbers());

    }

    private static Lotto createWinningLotto(List<Integer> integers) {
        return new Lotto(integers);
    }

    private static List<Lotto> createPurchasedLottos() {
        long totalAmount = InputView.inputTotalAmount();
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < totalAmount / LOTTO_PRICE; i++) {
            purchasedLottos.add(LottoFactory.createRandom());
        }

        return purchasedLottos;
    }
}
