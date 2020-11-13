import domain.LottoCalculator;
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
        Money buyingAmount = new Money(InputView.askMoneyAmount());
        Money lottoPrice = new Money(1000);
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        List<Integer> oneToFortyFive = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

        for(int i = 0; i < buyingAmount.dividedBy(lottoPrice); i++) {
            Collections.shuffle(oneToFortyFive);
            lottoNumbers.add(oneToFortyFive.stream().limit(6).sorted().collect(Collectors.toList()));
        }

        LottoCalculator lottoCalculator= new LottoCalculator(lottoNumbers);

        ResultView.print(lottoCalculator.getLottos());

        List<Integer> winningNumbers = InputView.askWinningNumbers().stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
