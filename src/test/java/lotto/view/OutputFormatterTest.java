package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OutputFormatterTest {

    @Test
    void 구매한_로또_개수를_출력한다() {
        assertThat(OutputFormatter.formatPurchaseCount(14)).isEqualTo("14개를 구매했습니다.");
    }

    @Test
    void 로또_번호_목록을_출력한다() {
        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));

        assertThat(OutputFormatter.formatLotto(lotto)).isEqualTo("[8, 21, 23, 41, 42, 43]");
    }

    @Test
    void 당첨_통계를_3개_일치부터_6개_일치까지_순서대로_출력하고_낙첨은_제외한다() {
        List<Rank> ranks = new ArrayList<>(Collections.nCopies(13, Rank.MISS));
        ranks.add(Rank.FOURTH);
        LottoResult result = new LottoResult(ranks, new PurchaseAmount(14000));

        assertThat(OutputFormatter.formatStatistics(result)).containsExactly(
                "3개 일치 (5000원)- 1개",
                "4개 일치 (50000원)- 0개",
                "5개 일치 (1500000원)- 0개",
                "6개 일치 (2000000000원)- 0개"
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1.0,  총 수익률은 1.00입니다.",
            "15.0, 총 수익률은 15.00입니다."
    })
    void 수익률을_출력한다(double profitRate, String expected) {
        assertThat(OutputFormatter.formatProfitRate(profitRate)).isEqualTo(expected);
    }

    @Test
    void 수익률이_1_미만이면_손해라는_안내_문구를_함께_출력한다() {
        assertThat(OutputFormatter.formatProfitRate(0.35))
                .isEqualTo("총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
