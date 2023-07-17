package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConsoleOutputWriter {

    private ConsoleOutputWriter() {
        throw new UnsupportedOperationException("Util 클래스의 인스턴스는 생성할 수 없습니다.");
    }

    private static void printLottos(final Lottos lottos) {
        System.out.println(buildLottosString(lottos));
    }

    public static void printLottoResultStatistic(final LottoResult lottoResult, final LottoMoney lottoMoney) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        String rankCountResult = buildRankCountString(lottoResult);
        System.out.println(rankCountResult);

        String ratioResult = buildRatioString(lottoResult, lottoMoney);
        System.out.println(ratioResult);
    }

    private static String buildLottosString(final Lottos lottos) {
        return lottos.getLottos().stream()
                .map(ConsoleOutputWriter::buildLottoContentString)
                .collect(Collectors.joining("\n"));
    }

    private static String buildLottoContentString(final Lotto lotto) {
        return lotto.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static String buildRankCountString(final LottoResult lottoResult) {
        return Arrays.stream(Rank.values())
                .sorted(ConsoleOutputWriter::descendingRankValue)
                .filter(rank -> rank != Rank.NONE)
                .map(rank -> buildRankResultString(rank, lottoResult.getCount(rank)))
                .collect(Collectors.joining("\n"));
    }

    private static String buildRankResultString(final Rank rank, final long count) {
        return String.format(
                "%d개 일치%s(%d원)- %d개",
                rank.getMatchLottoNumber(),
                rank.containsBonus() ? ", 보너스 볼 일치" : " ",
                rank.getPrize().getValue(),
                count
        );
    }

    private static String buildRatioString(final LottoResult lottoResult, final LottoMoney lottoMoney) {
        return String.format(
                "총 수익률은 %.2f입니다.",
                lottoResult.calculateRatio(lottoMoney).getValue()
        );
    }

    public static void printManualAndAutoLottos(final Lottos manualLottos, final Lottos autoLottos) {
        System.out.printf(
                "수동으로 %d장, 자동으로 %d개를 구매했습니다.%n",
                manualLottos.getLottos().size(),
                autoLottos.getLottos().size()
        );

        printLottos(manualLottos);
        printLottos(autoLottos);
    }

    private static int descendingRankValue(Rank from, Rank to) {
        return to.getValue() - from.getValue();
    }
}
