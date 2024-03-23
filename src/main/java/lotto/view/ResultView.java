package lotto.view;

import lotto.LottoMatchingService;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Price;
import lotto.domain.Prize;

import java.util.List;

public class ResultView {

    public void printInit() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumbersOfLotto(int numbersOfLotto) {
        System.out.println(numbersOfLotto + "개를 구매했습니다.");
    }

    public void printLottoTicketsNumbers(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.generateLottoNumbers());
        }
    }

    public void printDoInputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printResult(LottoMachine lottoMachine, List<Integer> winningNumbers, Price price) {
        LottoMatchingService lottoMatchingService = new LottoMatchingService(winningNumbers);
        List<Integer> integers = lottoMatchingService.matchWinningNumber(lottoMachine);
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Prize[] values = Prize.values();
        for (int i = 0; i < Prize.values().length - 1; i++) {
            System.out.println(values[i + 1].getMatchCount() + "개 일치 (" + values[i + 1].getWinningMoney() + "원)- " + integers.get(i) + "개");
        }
        System.out.printf("총 수익률은 %.2f", price.calculateRateOfReturn(integers));
    }

}
