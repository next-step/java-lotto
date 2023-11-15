package study.step2;

import java.util.*;

import study.step2.domain.LottoNumbers;
import study.step2.domain.LottoNumbersGenerator;
import study.step2.domain.dto.PurchaseAmount;

import static study.step2.view.InputView.input;
import static study.step2.view.ResultView.lottoCount;
import static study.step2.view.ResultView.show;

public class Step2Application {

    public static void main(String[] args) {
        PurchaseAmount amount = input();
        int numberOfLottos = amount.numberOfLottos();
        lottoCount(numberOfLottos);

        Random random = new Random();
        List<LottoNumbers> results = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            LottoNumbersGenerator generator = new LottoNumbersGenerator(random);
            results.add(generator.generate());
        }

        show(results);

    }
}
