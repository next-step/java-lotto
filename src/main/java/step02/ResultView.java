package step02;

import static step02.LottoConfig.*;

public class ResultView {

    private ResultView() {}

    public static void showBuyLottoResult(Lottos lottos) {
        System.out.printf(RESULT_BUY_N_COUNT + LINE_BRAKE, lottos.getLottoCount().getCount());
        System.out.println(lottos.toString());
    }

    public static void showLottoWinnerResult(LottoResultDTO resultDTO) {
        System.out.println(RESULT_WINNER_AVG);
        System.out.printf(RESULT_3_MATCHES + LINE_BRAKE, resultDTO.getRankFourthCount());
        System.out.printf(RESULT_4_MATCHES + LINE_BRAKE, resultDTO.getRankThirdCount());
        System.out.printf(RESULT_5_MATCHES + LINE_BRAKE, resultDTO.getRankSecondCount());
        System.out.printf(RESULT_6_MATCHES + LINE_BRAKE, resultDTO.getRankFirstCount());
        System.out.printf(RESULT_TOTAL_YIELD + LINE_BRAKE, resultDTO.getYield());
    }
}
