package lotto.view;

import lotto.LottoMatchingService;
import lotto.domain.LottoMachine;

import java.util.List;

public class ResultView {

    public void printInit() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printNumbersOfLotto(int numbersOfLotto) {
        System.out.println(numbersOfLotto + "개를 구매했습니다.");
    }

    public void printLottoTicketsNumbers(LottoMachine lottoMachine) {
        for (int i = 0; i < lottoMachine.showNumberOfLottos(); i++) {
            System.out.println((lottoMachine.getLottoTickets().get(i).getNumbers()));
        }
    }

    public void printDoInputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printResult(LottoMachine lottoMachine, List<Integer> winningNumbers, int price) {
        LottoMatchingService lottoMatchingService = new LottoMatchingService();
        List<Integer> integers = lottoMatchingService.matchWinningNumber(lottoMachine, winningNumbers);
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원)- " + integers.get(0) + "개");
        System.out.println("4개 일치 (50000원)- " + integers.get(1) + "개");
        System.out.println("5개 일치 (1500000원)- " + integers.get(2) + "개");
        System.out.println("6개 일치 (2000000000원)- " + integers.get(3) + "개");
        System.out.println("총 수익률은 " + calculateRateOfReturn(price, integers));
    }

    private double calculateRateOfReturn(int price, List<Integer> integers) {
        int totalRevenue = 5000 * integers.get(0)
                        + 50000 * integers.get(1)
                      + 1500000 * integers.get(2)
                   + 2000000000 * integers.get(3);
        int quotient = totalRevenue / price;
        double secondQuotient = (quotient * 10) / price * 0.1;
        double thirdQuotient = (totalRevenue * 10 - (quotient * 10 / price) * price) * 10 / 14000 * 0.01;
        return (quotient + secondQuotient + thirdQuotient) * 100 / 100;
    }

}
