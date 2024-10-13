package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoRewards;
import lotto.domain.Lottos;

public class ResultView {
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE = "---------";
    private static final String LOTTO_REWARD = "%d개 일치 (%d원)- %d개";

    public static void printLottos(final Lottos lottos) {
        System.out.println(lottos.getLottoCount() + LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers().stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .collect(Collectors.toList()));
        }
        System.out.println();
    }

    public static void printLottoStatistics(final LottoResult lottoResult) {
        System.out.println();
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        System.out.println(LINE);

        Map<LottoRewards, Integer> rewardsMap = lottoResult.getResultMap();
        List<LottoRewards> lottoRewards = Arrays.asList(LottoRewards.values());
        Collections.reverse(lottoRewards);

        for (LottoRewards lottoReward : lottoRewards) {
            printLottoReward(lottoReward, rewardsMap.get(lottoReward));
        }
    }

    private static void printLottoReward(final LottoRewards lottoReward, final int matchCount) {
        if (lottoReward.equals(LottoRewards.NONE)) {
            return;
        }
        System.out.printf(LOTTO_REWARD, lottoReward.getMatchCount(), lottoReward.getPrize(), matchCount);
        System.out.println();
    }
}
