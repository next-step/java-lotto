package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;

public class OutputView {
    public static final String MONEY_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String SECOND_RANK_STATISTICS_FORMAT = "%s개 일치, 보너스 볼 일치(%s원)- %s개\n";
    private static final String PURCHASED_LOTTO_COUNT_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.\n";
    private static final String RANK_STATISTICS_MESSAGE = "\n당첨 통계\n" + "---------";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %s입니다.";
    private static final String NORMAL_RANK_STATISTICS_FORMAT = "%s개 일치 (%s원)- %s개\n";

    public void printPurchasedLottoCnt(long manualLottoCount, long automaticLottoCount) {
        System.out.printf(PURCHASED_LOTTO_COUNT_MESSAGE, manualLottoCount, automaticLottoCount);
    }

    public void printPurchasedLottos(LottosDto purchasedLottos) {
        for (LottoDto lottoDto : purchasedLottos.getLottoDtos()) {
            System.out.println(sortLottoNumbers(lottoDto));
        }
    }

    private List<Integer> sortLottoNumbers(LottoDto lottoDto) {
        return lottoDto.getLottoNumbers().stream().sorted((a, b) -> a - b).collect(Collectors.toList());
    }

    public void printLottoRankStatistics(List<RankResultDto> rankResultDtos) {
        System.out.println(RANK_STATISTICS_MESSAGE);
        for (RankResultDto rankResultDto : rankResultDtos) {
            System.out.print(findRankResultFormat(rankResultDto));
        }
    }

    private String findRankResultFormat(RankResultDto rankResultDto) {
        if (rankResultDto.isSecond()) {
            return createSecondRankResultFormat(rankResultDto);
        }
        return createNormalRankResultFormat(rankResultDto);
    }

    private String createSecondRankResultFormat(RankResultDto rankResultDto) {
        return String.format(SECOND_RANK_STATISTICS_FORMAT,
                rankResultDto.getCountOfMatch(),
                rankResultDto.getPrizeMoney(),
                rankResultDto.getRankCount());
    }

    private String createNormalRankResultFormat(RankResultDto rankResultDto) {
        return String.format(NORMAL_RANK_STATISTICS_FORMAT,
                rankResultDto.getCountOfMatch(),
                rankResultDto.getPrizeMoney(),
                rankResultDto.getRankCount());
    }

    public void printLottoYield(double yield) {
        System.out.printf(TOTAL_YIELD_MESSAGE, yield);
        if (yield < 1) {
            System.out.println(MONEY_LOSS_MESSAGE);
        }
    }
}
