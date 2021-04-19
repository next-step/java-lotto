package step02.ui;

import step02.dto.LottoNumbersDTO;
import step02.dto.LottoResultDTO;
import step02.dto.LottosDTO;
import step02.model.lotto.LottoNumber;
import step02.model.lotto.LottoNumbers;

import java.util.Comparator;

import static step02.utils.LottoConfig.*;

public class ResultView {

    private ResultView() {
    }

    public static void showBuyLottoResult(LottosDTO lottosDTO) {
        System.out.printf(RESULT_BUY_N_COUNT + LINE_BRAKE, lottosDTO.getManualLottoCount(), lottosDTO.getAutomaticLottoCount());
        System.out.println(getLottosToString(lottosDTO));
    }

    public static void showLottoWinnerResult(LottoResultDTO resultDTO) {
        String result = RESULT_WINNER_AVG + LINE_BRAKE +
                String.format(RESULT_FIFTH + LINE_BRAKE, resultDTO.getRankFifthCount()) +
                String.format(RESULT_FORTH + LINE_BRAKE, resultDTO.getRankFourthCount()) +
                String.format(RESULT_THIRD + LINE_BRAKE, resultDTO.getRankThirdCount()) +
                String.format(RESULT_SECOND + LINE_BRAKE, resultDTO.getRankSecondCount()) +
                String.format(RESULT_FIRST + LINE_BRAKE, resultDTO.getRankFirstCount()) +
                String.format(RESULT_TOTAL_YIELD + LINE_BRAKE, resultDTO.getYield());
        System.out.println(result);
    }

    private static String getLottoNumbersToString(LottoNumbersDTO lottoNumbersDTO) {
        StringBuilder stringBuilder = new StringBuilder();
        final int[] index = {ZERO};

        lottoNumbersDTO.getLottoNumbers().stream().sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .forEach(lottoNumber -> {
                    stringBuilder.append(lottoNumber.getLottoNumber());
                    addSeparate(lottoNumbersDTO.getLottoNumberSize(), index[0], stringBuilder);
                    index[0]++;
                });

        return stringBuilder.toString();
    }

    private static void addSeparate(int totalNumberCount, int index, StringBuilder stringBuilder) {
        if (index < totalNumberCount - ONE) {
            stringBuilder.append(REGEX + BLANK);
        }
    }

    private static String getLottosToString(LottosDTO lottosDTO) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumbers lottoNumbers : lottosDTO.getLottos()) {
            stringBuilder.append(START_LOTTO_SYMBOL)
                    .append(getLottoNumbersToString(lottoNumbers.getLottoNumbersResult()))
                    .append(END_LOTTO_SYMBOL)
                    .append(LINE_BRAKE);
        }
        return stringBuilder.toString();
    }
}
