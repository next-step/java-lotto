import lotto.domain.Lotto;
import lotto.view.Input;
import lotto.view.Output;

import java.math.BigDecimal;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        BigDecimal amount = Input.inputAmount();
        int manualLottoCount = Input.inputManualLottoCount();
        List<Lotto> manualLottoNumbers = Input.inputManualNumberList(manualLottoCount);

        List<Lotto> numbers = Output.print(manualLottoNumbers, manualLottoCount, amount);
        List<Integer> winnerNumbers = Input.inputWinnerNumberList();
        Integer bonusBallNumber = Input.inputBonusBallNumber();

        List<Lotto> lottoList = Output.getRank(numbers, winnerNumbers, bonusBallNumber);
        Output.getResult(lottoList);
    }
}
