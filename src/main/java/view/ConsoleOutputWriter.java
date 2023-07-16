package view;

import domain.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ConsoleOutputWriter implements OutputWriter {

    @Override
    public void printLottosInfo(final Lottos lottos) {
        System.out.println(buildLottosString(lottos));
    }

    @Override
    public void printLottoResultStatistic(final LottoResult lottoResult, final long money) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        String rankCountResult = buildRankCountString(lottoResult);
        System.out.println(rankCountResult);

        String ratioResult = buildRatioString(lottoResult, money);
        System.out.println(ratioResult);
    }

    private String buildLottosString(final Lottos lottos) {
        return lottos.getLottos().stream()
                .map(this::buildLottoString)
                .collect(Collectors.joining("\n"));
    }

    private String buildLottoString(final Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private String buildRankCountString(final LottoResult lottoResult) {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder()) // TODO: 좀 더 구체적으로 변경
                .filter(rank -> rank != Rank.NONE) // TODO: Rank 객체에 메시지 전달?
                .map(rank -> buildRankResultString(rank, lottoResult.getCount(rank)))
                .collect(Collectors.joining("\n"));
    }

    private String buildRankResultString(final Rank rank, final long count) {
        return String.format(
                "%d개 일치%s(%d원)- %d개",
                rank.getMatchLottoNumber(),
                rank.containsBonus() ? ", 보너스 볼 일치" : " ",
                rank.getPrize(),
                count
        );
    }

    private String buildRatioString(final LottoResult lottoResult, final long money) {
        return String.format(
                "총 수익률은 %.2f입니다.",
                lottoResult.calculateRateOfReturn(money)
        );
    }
}
