package study.step2;

import java.util.*;
import java.util.stream.Collectors;

import study.step2.domain.*;
import study.step2.domain.dto.PurchaseAmount;
import study.step2.domain.dto.WinningNumbers;

import static study.step2.view.InputView.input;
import static study.step2.view.InputView.inputWinningNumbers;
import static study.step2.view.ResultView.showLottoCount;
import static study.step2.view.ResultView.showLottos;

public class Step2Application {

    public static void main(String[] args) {
        PurchaseAmount amount = input();
        int numberOfLottos = amount.numberOfLottos();
        showLottoCount(numberOfLottos);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            LottoGenerator generator = new LottoGenerator(new Random());
            lottos.add(generator.generate());
        }
        showLottos(lottos);

        WinningNumbers winningNumbers = inputWinningNumbers();
        List<Rank> ranks = lottos.stream()
            .map(lotto -> lotto.match(winningNumbers))
            .collect(Collectors.toList());
    }
}
