package step02.ui;

import step02.dto.LottoResultDTO;
import step02.dto.LottosDTO;

import static step02.utils.LottoConfig.*;

public class ResultView {

    private ResultView() {}

    public static void showBuyLottoResult(LottosDTO lottosDTO) {
        System.out.printf(RESULT_BUY_N_COUNT + LINE_BRAKE, lottosDTO.getLottoCount());
        System.out.println(lottosDTO.getLottosToString());
    }

    public static void showLottoWinnerResult(LottoResultDTO resultDTO) {
        System.out.println(RESULT_WINNER_AVG);
        System.out.printf(RESULT_FIFTH + LINE_BRAKE, resultDTO.getRankFifthCount());
        System.out.printf(RESULT_FORTH + LINE_BRAKE, resultDTO.getRankFourthCount());
        System.out.printf(RESULT_THIRD + LINE_BRAKE, resultDTO.getRankThirdCount());
        System.out.printf(RESULT_SECOND + LINE_BRAKE, resultDTO.getRankSecondCount());
        System.out.printf(RESULT_FIRST + LINE_BRAKE, resultDTO.getRankFirstCount());
        System.out.printf(RESULT_TOTAL_YIELD + LINE_BRAKE, resultDTO.getYield());
    }
}
