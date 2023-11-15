package study.step2;

import java.util.*;

import study.step2.domain.Lotto;
import study.step2.domain.LottoGenerator;
import study.step2.domain.dto.PurchaseAmount;

import static study.step2.view.InputView.input;
import static study.step2.view.InputView.inputWinningNumbers;
import static study.step2.view.ResultView.lottoCount;
import static study.step2.view.ResultView.show;

public class Step2Application {

    public static void main(String[] args) {
        PurchaseAmount amount = input();
        int numberOfLottos = amount.numberOfLottos();
        lottoCount(numberOfLottos);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            LottoGenerator generator = new LottoGenerator(new Random());
            lottos.add(generator.generate());
        }
        show(lottos);
        lottos.forEach(lotto -> lotto.match(inputWinningNumbers()));
    }
}
