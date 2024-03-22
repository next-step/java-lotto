package lotto.view;

import lotto.LottoMatchingService;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
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

    public void printResult(LottoMachine lottoMachine, List<Integer> winningNumbers, int price) {
        LottoMatchingService lottoMatchingService = new LottoMatchingService(winningNumbers);
        List<Integer> integers = lottoMatchingService.matchWinningNumber(lottoMachine);
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        Prize[] values = Prize.values();
        for (int i = 0; i < Prize.values().length - 1; i++) {
            System.out.println(values[i + 1].getMatchCount() + "개 일치 (" + values[i + 1].getPrice() + "원)- " + integers.get(i) + "개");
        }
        System.out.printf("총 수익률은 %.2f", calculateRateOfReturn(price, integers));
    }

    private double calculateRateOfReturn(int price, List<Integer> integers) {
        int totalRevenue = 0;
        Prize[] values = Prize.values();
        for (int i = 0; i < values.length - 1; i++) {
            totalRevenue += values[i + 1].getPrice() * integers.get(i);
        }
        int quotient = totalRevenue / price;
        double secondQuotient = (quotient * 10) / price * 0.1;
        double thirdQuotient = (totalRevenue * 10 - secondQuotient * price) * 10 / 14000 * 0.01;
        return (quotient + secondQuotient + thirdQuotient) * 100 / 100;
    }

}
