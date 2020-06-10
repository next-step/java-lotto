package lotto.view;

public class OutputView {
    /*
     * 구입한 로또의 갯수를 출력하는 뷰
     * 로또 번호를 출력하는 뷰
     * 당첨 통계를 출력하는 뷰 - 3, 4, 5, 6개 일치
     * 수익률을 출력하는 뷰
     */

    private enum Rank {
        ALL_MATCH(6, 2000000000),
        MISS_ONE(5, 1500000),
        MISS_TWO(4, 50000),
        MISS_THREE(3,5000);

        private final int matchNumber;
        private final int prize;

        Rank(int matchNumber, int prize) {
            this.matchNumber = matchNumber;
            this.prize = prize;
        }
    }

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

    // TODO: 당첨된 로또 갯수 몇 개인지 어떻게 알아내지?
    public void winningResultView() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", rank.matchNumber, rank.prize, -999);
        }
    }

    public void printEarningRateView(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
