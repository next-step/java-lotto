package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoClient {
    private static int receiveMoney;
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoPrice lottoPrice = new LottoPrice();
        Lotto lotto = new Lotto();

        input(inputView, lottoPrice, lotto);

        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputQuestion("지난 주 당첨 번호를 입력해 주세요.").replaceAll(" ", "").split(","));
        winningNumbers.bonusNumber(Integer.parseInt(inputView.inputQuestion("보너스 볼을 입력해 주세요.").replaceAll(" ", "")));
        winningNumbers.choose(lotto.lotto());

        printWinNumbers(inputView, winningNumbers.ranks(), winningNumbers.earningsRate(receiveMoney));
    }

    private static void input(InputView inputView, LottoPrice lottoPrice, Lotto lotto) {
        receiveMoney = Integer.parseInt(inputView.inputQuestion("구입금액을 입력해 주세요."));
        int lottoTicketNumber = lottoPrice.lottoTicketNumber(receiveMoney);
        inputView.print(lottoTicketNumber + "개를 구매했습니다.");
        lotto.buy(lottoTicketNumber);

        for (LottoNumbers marked : lotto.lotto()) {
            System.out.println(marked.toString());
        }
    }

    private static void printWinNumbers(InputView inputView, Map<Rank, Integer> ranks, double earningsRate) {
        ResultView resultView = new ResultView();
        inputView.print("당첨 통계");
        inputView.print("---------");

        resultView.print("3개 일치 , (5000원)- " + ranks.get(Rank.FIFTH) +"개");
        resultView.print("3개 일치 , (5000원)- " + ranks.get(Rank.FIFTH) +"개");
        resultView.print("4개 일치 , (50000원)- " + ranks.get(Rank.FOURTH) +"개");
        resultView.print("5개 일치 , (1500000원)- " + ranks.get(Rank.THIRD) +"개");
        resultView.print("5개 일치 , 보너스 볼 일치 (30000000원)- " + ranks.get(Rank.SECOND) +"개");
        resultView.print("6개 일치 , (2000000000원)- " + ranks.get(Rank.FIRST) +"개");
        resultView.print("총 수익률은 " + earningsRate + "입니다.");
    }
}
