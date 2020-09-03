package view;

import domain.Lotto;
import domain.Lottos;
import domain.Rank;
import domain.RankRecord;

import static utility.UserInput.WON;

public class View {
    private static final int LOTTO_NUMBER = 6;
    private static final int ZERO = 0;

    public static void result(RankRecord record, long sum, int buyInput) {
        System.out.println(sum);
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치(5000원)- " + record.getRecordPool().get(Rank.RANK_FIVE) + "개");
        System.out.println("4개 일치(50000원)- " + record.getRecordPool().get(Rank.RANK_FOUR) + "개");
        System.out.println("5개 일치(1500000원)- " + record.getRecordPool().get(Rank.RANK_THREE) + "개");
        System.out.println("5개 일치,보너스 볼 일치(30000000원)- " + record.getRecordPool().get(Rank.RANK_TWO) + "개");
        System.out.println("6개 일치(2000000000원)- " + record.getRecordPool().get(Rank.RANK_ONE) + "개");

        if (sum == ZERO) {
            System.out.println("총 수익률은 0 입니다.");
            return;
        }

        System.out.printf("총 수익률은 %.2f 입니다", (double) sum / buyInput);
    }

    public static void getLottoNumbers(Lotto lotto) {
        System.out.print("[");
        for (int j = 0; j < LOTTO_NUMBER; j++) {
            System.out.print(lotto.getLottoNumber().get(j).getNumber() + " ");
        }
        System.out.println("]");
    }

    public static void showLottoTickets(Lottos lottos) {
        for (int i = 0; i < lottos.getNumOfLottos(); i++) {
            View.getLottoNumbers(lottos.getOneLotto(i));
        }
    }

    public static void showManualAndAutoNumber(int buyInput, int manual) {
        int auto = buyInput / WON - manual;
        System.out.printf("수동으로 %d장, 자동으로 %d", manual, auto);
        System.out.println("개를 구매했습니다");
    }
}
