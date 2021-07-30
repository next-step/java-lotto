package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DosResultView implements ResultView {
    @Override
    public void printLottoList(LottoList lottoList) {
        System.out.println(Text.PURCHASED_LOTTO_SIZE.format(
                lottoList.size()
        ));
        for (Lotto iLotto : lottoList)
            System.out.println(iLotto);
    }

    private List<LottoRank> displayLottoRanks() {
        return Arrays.stream(LottoRank.values())
                .filter(iLottoRank -> iLottoRank.matchesCount() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println(Text.RESULT_TITLE);
        for (LottoRank iLottoRank : displayLottoRanks()) {
            System.out.println(
                    Text.LOTTO_RANK.format(
                            iLottoRank.matchesCount(),
                            iLottoRank.prizeAmount(),
                            lottoStatistics.size(iLottoRank)
                    )
            );
        }
        float yield = lottoStatistics.yield().floatValue();
        Text resultText = yield < 1 ? Text.YIELD_LOSS : Text.YIELD;
        System.out.println(
                resultText.format(lottoStatistics.yield().floatValue())
        );
    }

    @Override
    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    private enum Text {
        PURCHASED_LOTTO_SIZE("%d개를 구매 했습니다."),
        RESULT_TITLE("당첨 통계\n---------"),
        LOTTO_RANK("%s개 일치 (%s원) - %d개"),
        YIELD("총 수익률은 %.2f 입니다."),
        YIELD_LOSS("총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");

        private final String str;

        Text(String str) {
            this.str = str;
        }

        public String format(Object... objs) {
            return String.format(str, objs);
        }

        @Override
        public String toString() {
            return str;
        }
    }
}
