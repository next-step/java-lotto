package lotto;

import java.util.HashMap;

public class LottoApplication {
    public static void main(String[] args) {
        int quantity = InputView.quantity();
        LottoMachine lottoMachine = new LottoMachine(quantity);

        InputView.print(lottoMachine.lottos());

        LottoNumbers winningNumbers = InputView.winningNumbers();
        HashMap<Integer, Long> result = lottoMachine.result(winningNumbers);

        InputView.summary(result);
    }
}
