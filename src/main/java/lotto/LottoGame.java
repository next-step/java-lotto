package lotto;

import lotto.domain.LottoMaker;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        System.out.println("구매할 로또 금액을 입력하세요.");
        int count = inputView.buyLotto(sc.nextInt());

        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            lottos.addLotto(LottoMaker.run());
        }

        System.out.println("지난주 당첨 번호를 입력하세요.");

        List<Integer> correctNumbers = inputView.makeCorrectNumber(sc.next());
        Collections.sort(correctNumbers);

        for(int i = 0; i < lottos.getSize(); i++) {
            int checkCount = resultView.correctCheck(lottos.getLotto(i), correctNumbers);
            System.out.println(checkCount);
        }

        //일치갯수당 등수 나열

    }
}
