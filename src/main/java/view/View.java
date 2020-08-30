package view;

import domain.Lotto;
import domain.LottoGames;
import domain.Lottos;
import utility.UserInput;

public class View {

    private static final int ZERO = 0;
    private static final int ONE= 1;
    private static final int TWO= 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    public static void result(LottoGames game, int sum) {
        System.out.println(sum);
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치(5000원)- " + game.getRankRecord().getRecordPool().get(FIVE) + "개");
        System.out.println("4개 일치(50000원)- " + game.getRankRecord().getRecordPool().get(FOUR) + "개");
        System.out.println("5개 일치(1500000원)- " + game.getRankRecord().getRecordPool().get(THREE) + "개");
        System.out.println("5개 일치,보너스 볼 일치(30000000원)- " + game.getRankRecord().getRecordPool().get(TWO) + "개");
        System.out.println("6개 일치(2000000000원)- " + game.getRankRecord().getRecordPool().get(ONE) + "개");

        if (sum == ZERO) {
            System.out.println("총 수익률은 0 입니다.");
            return;
        }
        System.out.printf("총 수익률은 %.2f 입니다", (double) sum / (game.getLottos().getNumOfLottos()* UserInput.WON));
    }

    public static void getLottoNumbers(Lotto lotto) {
        System.out.print("[");
        for (int j = 0; j < LottoGames.LOTTO_NUMBER; j++) {
            System.out.print(lotto.getLottoNumber().get(j) + " ");
        }
        System.out.println("]");
    }

    public static void showLottoTickets(Lottos lottos) {
        for (int i = 0; i < lottos.getNumOfLottos(); i++) {
            View.getLottoNumbers(lottos.getOneLotto(i));
        }
    }
}
