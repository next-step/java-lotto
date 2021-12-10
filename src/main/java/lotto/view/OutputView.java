package lotto.view;

import lotto.LottoResult;
import lotto.Lottos;

public class OutputView {

    private static final String OUTPUT_MESSAGE_HOW_MANY_LOTTOS_BOUGHT = "%d개를 구매했습니다.\n";
    private static final String OUTPUT_MESSAGE_LOTTO_RESULT_ANNOUNCE = "\n당첨 통계\n" + "---------";
    private static final String OUTPUT_MESSAGE_3_NUMBERS_MATCH = "3개 일치 (5000원)- %d개\n";
    private static final String OUTPUT_MESSAGE_4_NUMBERS_MATCH = "4개 일치 (50000원)- %d개\n";
    private static final String OUTPUT_MESSAGE_5_NUMBERS_MATCH = "5개 일치 (1500000원)- %d개\n";
    private static final String OUTPUT_MESSAGE_6_NUMBERS_MATCH = "6개 일치 (2000000000원)- %d개\n";

    private static final int THIRD_WIN_COUNT = 3;
    private static final int FOURTH_WIN_COUNT = 4;
    private static final int FIFTH_WIN_COUNT = 5;
    private static final int SIXTH_WIN_COUNT = 6;

    public void showHowManyLottosBoughtWithMoney(Lottos lottos) {
        System.out.printf((OUTPUT_MESSAGE_HOW_MANY_LOTTOS_BOUGHT), lottos.count());
    }

    public void showLottos(Lottos lottos) {
        System.out.println(lottos.lottoToString());
    }

    public void showLottoResult(LottoResult lottoResult) {
        System.out.println(OUTPUT_MESSAGE_LOTTO_RESULT_ANNOUNCE);
        System.out.printf(OUTPUT_MESSAGE_3_NUMBERS_MATCH, lottoResult.winnerCount(THIRD_WIN_COUNT));
        System.out.printf(OUTPUT_MESSAGE_4_NUMBERS_MATCH, lottoResult.winnerCount(FOURTH_WIN_COUNT));
        System.out.printf(OUTPUT_MESSAGE_5_NUMBERS_MATCH, lottoResult.winnerCount(FIFTH_WIN_COUNT));
        System.out.printf(OUTPUT_MESSAGE_6_NUMBERS_MATCH, lottoResult.winnerCount(SIXTH_WIN_COUNT));
    }
}
