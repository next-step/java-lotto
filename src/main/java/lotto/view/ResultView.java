package lotto.view;

import lotto.domain.Rank;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printResultBuyCount(long manualLottosCount, long autoLottosCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottosCount, autoLottosCount);
    }

    public static void printLottos(LottosDto manualLottosDto, LottosDto autoLottosDto) {
        List<LottoDto> manualLottos = manualLottosDto.getLottos();
        List<LottoDto> autoLottos = autoLottosDto.getLottos();
        printResultBuyCount(manualLottos.size(), autoLottos.size());
        manualLottos.forEach(ResultView::printLotto);
        autoLottos.forEach(ResultView::printLotto);
    }
    private static void printLotto(LottoDto lotto) {
        System.out.println(lotto.getLotto());
    }

    public static void printWinningMatchCount(RankResultDto rankResultDto) {
        Map<Rank, Long> rankResult = rankResultDto.getRankResult();
        System.out.println("당첨 통계");
        System.out.println("-----------");
        Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printRankResult(rank, rankResult.getOrDefault(rank, 0L)));
    }

    private static void printRankResult(Rank rank, Long count) {
        if (rank == Rank.MISS) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getCount());
        sb.append("개 일치");
        if (rank == Rank.SECOND) {
            sb.append(",");
        }
        sb.append(" ");
        if (rank == Rank.SECOND) {
            sb.append("보너스 볼 일치");
        }
        sb.append("(");
        sb.append(rank.getMoney().toLong());
        sb.append("원)- ");
        sb.append(count);
        sb.append("개");
        System.out.println(sb);
    }

    public static void printRateOfEarning(double rateOfEarning) {
        String message = "총 수익률은 %.2f입니다.";
        if (rateOfEarning < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        System.out.printf(message, rateOfEarning);
    }
}
