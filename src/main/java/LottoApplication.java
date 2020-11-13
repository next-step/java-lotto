import domain.LottoCalculator;
import domain.LottoResult;
import domain.Money;
import ui.InputView;
import ui.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoApplication {

    public static void main(String[] args) throws Exception {
        Money buyingAmount = Money.of(InputView.askMoneyAmount());
        Money lottoPrice = Money.of(1000L);

        List<List<Integer>> lottoNumbers = new ArrayList<>();
        List<Integer> oneToFortyFive = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

        for(int i = 0; i < buyingAmount.dividedBy(lottoPrice); i++) {
            Collections.shuffle(oneToFortyFive);
            lottoNumbers.add(oneToFortyFive.stream().limit(6).sorted().collect(Collectors.toList()));
        }

        ResultView.printBuyingLottos(lottoNumbers);

        List<Integer> winningNumbers = InputView.askWinningNumbers();

        LottoCalculator lottoCalculator= new LottoCalculator(lottoNumbers);
        LottoResult lottoResult = lottoCalculator.calculate(winningNumbers);

        ResultView.printLottoResult(lottoResult);
    }
}
