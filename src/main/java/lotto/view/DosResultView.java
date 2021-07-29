package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;

public class DosResultView implements ResultView {
    @Override
    public void printLottoList(LottoList lottoList) {
        System.out.println(Text.PURCHASED_LOTTO_SIZE.format(
                lottoList.size()
        ));
        for (Lotto iLotto : lottoList)
            System.out.println(iLotto);
    }

    @Override
    public void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println(Text.RESULT_TITLE);
        for (LottoRank iLottoRank : LottoRank.values()) {
            System.out.println(
                    Text.LOTTO_RANK.format(
                            iLottoRank,
                            lottoStatistics.size(iLottoRank)
                    )
            );
        }
        System.out.println(
                Text.YIELD.format(lottoStatistics.yield().floatValue())
        );
    }

    @Override
    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    private enum Text {
        PURCHASED_LOTTO_SIZE("%d개를 구매 했습니다."),
        RESULT_TITLE("당첨 통계\n---------"),
        LOTTO_RANK("%s - %d개"),
        YIELD("총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");

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
