package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultSetTest {

    private LottoResultSet lottoResultSet;

    @Before
    public void setup() {
        lottoResultSet = LottoResultSet.create(Arrays.asList(
                LottoResult.create(LottoMachine.LottoType.THREE, 1),
                LottoResult.create(LottoMachine.LottoType.BONUS, 1)
        ));
    }

    @Test
    public void 로또결과목록으로_로또결과셋을_생성할수있다() {
        assertThat(lottoResultSet).isNotNull();
    }

    @Test
    public void 당첨금액을_알수있다() {
        // 3개 일치(1개의 5000원 * 1개
        // 5개 일치, 보너스 볼 일치(30000000원) * 1개
        assertThat(lottoResultSet.reward()).isEqualTo(30_005_000);
    }

    @Test
    public void 수익률을_알수있다() {
        // 5개 일치, 보너스 볼 일치(30000000원) * 1개
        assertThat(lottoResultSet.rateReturn(30_010_000)).isLessThan(BigDecimal.ONE);
    }
}