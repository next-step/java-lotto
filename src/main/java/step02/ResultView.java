package step02;

import static step02.LottoConfig.*;

public class ResultView {

    private ResultView() {}

    public static void showBuyLottoResult(Lottos lottos) {
        System.out.println(lottos.getLottoCount().getCount() + RESULT_BUY_N_COUNT);
        System.out.println(lottos.toString());
    }

    public static void showLottoWinnerResult(LottoResultDTO resultDTO) {
        System.out.println(RESULT_WINNER_AVG);
        System.out.printf(RESULT_3_MATCHES + LINE_BRAKE, resultDTO.getMath3());
        System.out.printf(RESULT_4_MATCHES + LINE_BRAKE, resultDTO.getMath4());
        System.out.printf(RESULT_5_MATCHES + LINE_BRAKE, resultDTO.getMath5());
        System.out.printf(RESULT_6_MATCHES + LINE_BRAKE, resultDTO.getMath6());
        System.out.printf(RESULT_TOTAL_YIELD + LINE_BRAKE, resultDTO.getYield());
    }
}
