package lotto;

import java.util.Scanner;

import lotto.domain.*;
import lotto.view.LottoFormView;
import lotto.view.LottoResultView;

public class LottoGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Money money = LottoFormView.inputMoney(scanner);
        Lottos lottos = LottoGenerator.generateByMoney(money);
        System.out.println(lottos);

        WinningLotto winningLotto = LottoFormView.inputWinningLotto(scanner);
        MatchingResults result = lottos.match(winningLotto);

        LottoResultView.show(result);
        scanner.close();
    }
}
