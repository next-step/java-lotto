package lotto.view;

import lotto.dto.RankDto;
import lotto.dto.ResultDto;
import lotto.entity.Lotto;

import java.math.BigDecimal;
import java.util.List;

public class ResultView {
    private static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String TITLE = "당첨 통계";
    private static final String DIVIDER = "----------";
    private static final String COUNT_MESSAGE = "%d개 일치 (%.0f원)- %d개 \n";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.02f%%입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printCreateLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + BUY_COUNT_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(ResultDto result) {
        System.out.println(TITLE);
        System.out.println(DIVIDER);

        printRank(result.getRankDtos());
        printRateOfReturn(result.getRate());
    }

    private static void printRank(List<RankDto> rankDtos) {
        for (RankDto rankDto : rankDtos) {
            System.out.printf(COUNT_MESSAGE, rankDto.getCollectCount(), rankDto.getPrizeMoney(), rankDto.getCount());
        }
    }

    private static void printRateOfReturn(BigDecimal rate) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rate);
    }


}
