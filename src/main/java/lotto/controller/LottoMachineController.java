package lotto.controller;

import static lotto.common.Properties.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoNumberFactory;
import lotto.domain.LottoNumbers;
import lotto.view.InputView;

public class LottoMachineController {

    public static void main(String[] args) {
        List<LottoNumbers> purchasedLottos = createPurchasedLottos();
        LottoNumbers winningNumber = createWinningLotto(InputView.inputWinningNumbers());

    }

    private static LottoNumbers createWinningLotto(List<Integer> integers) {
        return new LottoNumbers(integers);
    }

    private static List<LottoNumbers> createPurchasedLottos() {
        long totalAmount = InputView.inputTotalAmount();
        List<LottoNumbers> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < totalAmount / LOTTO_PRICE; i++) {
            purchasedLottos.add(new LottoNumbers(LottoNumberFactory.createRandomNumbers()));
        }

        return purchasedLottos;
    }
}
