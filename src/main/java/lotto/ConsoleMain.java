package lotto;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleMain {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String money = scanner.nextLine();

        Purchase purchase = new Purchase(money);
        int quantity = purchase.purchaseQuantity();
        System.out.println(quantity + "개를 구매했습니다.");

        int index = 0;
        List<Lotto> lottos = new ArrayList<>();
        ResultView resultView = new ResultView();

        while(index < quantity) {
            List<Integer> numbers = Utils.generateLottoNumber();
            lottos.add(new Lotto(new LottoNumbers(numbers)));
            resultView.printLotto(numbers);
            index++;
        }

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winner = scanner.nextLine();
        String[] winnerStringNumbers = Utils.stringSplitWithDelimiter(winner, ",");
        List<Integer> winnerNumbers = new ArrayList<>();
        for (String winnerNumber : winnerStringNumbers) {
            winnerNumbers.add(Utils.toInt(winnerNumber));
        }
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(winnerNumbers));
        Lottos lottoList = new Lottos(lottos);
        int totalPrize = lottoList.totalPrize(winningLotto);
        LottoResult lottoResult = new LottoResult(purchase, totalPrize);

        resultView.printLottoResult(lottos, winningLotto);
        resultView.printEarningsRate(lottoResult.earningsRate());
    }
}
