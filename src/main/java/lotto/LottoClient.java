package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

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

        printWinNumbers(inputView, winningNumbers, lotto);
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

    private static void printWinNumbers(InputView inputView, WinningNumbers winningNumbers, Lotto lotto) {
        Map<Integer, Integer> winNumbersMap = winningNumbers.getWinNumbers(lotto);

        inputView.print("당첨 통계");
        inputView.print("---------");
        System.out.println("3개 일치 , (5000원)- " + winNumbersMap.get(3) +"개");
        System.out.println("4개 일치 , (50000원)- " + winNumbersMap.get(4) +"개");
        System.out.println("5개 일치 , (1500000원)- " + winNumbersMap.get(5) +"개");
//        System.out.println("5개 일치 , 보너스 볼 일치 (30000000원)- " + ((winningNumbers.isBonusNumber()) ? winNumbersMap.get(5) : 0) +"개");
        System.out.println("6개 일치 , (2000000000원)- " + winNumbersMap.get(6) +"개");
        System.out.println("총 수익률은 " + winningNumbers.earningsRate(receiveMoney) + "입니다.");
    }
}
