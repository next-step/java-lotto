package lotto.view;

import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import lotto.model.Rank;

public class OutputView {
    /*
     * 구입한 로또의 갯수를 출력하는 뷰
     * 로또 번호를 출력하는 뷰
     * 당첨 통계를 출력하는 뷰 - 3, 4, 5, 6개 일치
     * 수익률을 출력하는 뷰
     */

    public void howManyLottoTicketsView(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printLottoNumbersView(LottoNumbers numbers) {
        LottoNumber[] lottoNumbers = numbers.getNumbers();
        System.out.print("[");
        for (int i = 0; i < lottoNumbers.length - 1; i++) {
            System.out.print(lottoNumbers[i].getNumber() + ", ");
        }
        System.out.println(lottoNumbers[lottoNumbers.length - 1].getNumber() + "]");
    }

    public void winningResultView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            StringBuilder msg = new StringBuilder("개 일치");
            if (rank == Rank.SECOND) {
                msg.append(", 보너스 볼 일치 ");
            }
            System.out.printf("%d" + msg + " (%d원)- %d개\n", rank.getMatchNumber(), rank.getPrize(), rank.getMatchCount());
        }
    }

    public void printEarningRateView(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
