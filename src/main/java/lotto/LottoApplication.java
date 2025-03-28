package lotto;

import calculator.Operator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Integer lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        Integer lottoQuantity = Operator.DIVIDE.formula.apply(lottoPurchaseAmount, LOTTO_PRICE);
        OutputView.showLottoQuantity(lottoQuantity);

        List<Lotto> lottos = new ArrayList<>();;
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto lotto = new Lotto(LottoNumberAutoGenerator.generateNumbers());
            OutputView.showLottoNumbers(lotto.getLottoNumbers());
            lottos.add(lotto);
        }

        List<Integer> winningLotto = Arrays.stream(InputView.showWinningLottoNumbersInput().split(",")).map(Integer::parseInt).collect(Collectors.toList());

    }
}
