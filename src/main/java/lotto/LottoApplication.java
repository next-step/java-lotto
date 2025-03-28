package lotto;

import calculator.Operator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Integer lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        Integer lottoQuantity = Operator.DIVIDE.formula.apply(lottoPurchaseAmount, LOTTO_PRICE);
        OutputView.showLottoQuantity(lottoQuantity);

        List<List<Integer>> lottos = new ArrayList<>();;
        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = LottoNumberAutoGenerator.generateNumbers();
            OutputView.showLottoNumbers(numbers);
            lottos.add(numbers);
        }
    }
}
