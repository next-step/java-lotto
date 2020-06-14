package lotto.view;

import lotto.model.Lotto;

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

    public void printLottoNumbersView(int[] lottoNumbers) {
        System.out.print("[");
        for (int i = 0; i < lottoNumbers.length - 1; i++) {
            System.out.print(lottoNumbers[i] + ", ");
        }
        System.out.println(lottoNumbers[lottoNumbers.length - 1] + "]");
    }

    public void winningResultView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Lotto.Rank rank : Lotto.Rank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.getMatchNumber(), rank.getPrize(), rank.getCount());
        }
    }

    public void printEarningRateView(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
