package lotto.view;

import static java.text.MessageFormat.format;
import static lotto.domain.reward.LottoRank.NONE;
import static lotto.domain.reward.LottoRank.SECOND;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.reward.LottoRank;
import lotto.domain.reward.LottoResult;
import lotto.view.io.Output;

public class LottoOutputView {

    private static final long LOTTO_RESULT_DEFAULT_MATCHING_COUNT = 0L;

    private final Output output;

    public LottoOutputView(final Output output) {
        this.output = output;
    }

    public void printLottoPurchaseHistory(final List<Lotto> lottos) {
        output.printLine(format("{0}개를 구매했습니다.", lottos.size()));

        lottos.forEach(lotto -> {
            final List<Integer> numbers = lotto.extractLottoNumbers();
            numbers.sort(Comparator.naturalOrder());
            output.printLine(numbers.toString());
        });
    }

    public void printLottoWinningResult(final LottoResult lottoResult) {
        output.printLine("\n당첨 통계\n---------");

        final Map<LottoRank, Long> result = lottoResult.result();

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != NONE)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> printLottoResultByRank(rank, result));

        output.printLine(format("총 수익률은 {0}입니다. (1보다 크면 이익, 작으면 손해입니다.)", lottoResult.profitRate()));
    }

    private void printLottoResultByRank(final LottoRank rank, final Map<LottoRank, Long> result) {
        final String lottoResultOutputByRank = format(
                (rank == SECOND) ? "{0}개, 보너스 일치 ({1}원) - {2}개" : "{0}개 일치 ({1}원) - {2}개",
                rank.matchingCount(),
                rank.rewardAmount(),
                result.getOrDefault(rank, LOTTO_RESULT_DEFAULT_MATCHING_COUNT)
        );

        output.printLine(lottoResultOutputByRank);
    }

    public void printBusinessExceptionMessage(final String message) {
        output.printLine(message);
    }

    public void printUnexpectedExceptionMessage() {
        output.printLine("알 수 없는 예외가 발생했습니다.");
    }
}
