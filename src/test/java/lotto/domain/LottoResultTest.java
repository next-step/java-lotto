package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    @Before
    public void setup() {
        lottoResult = LottoResult.create(LottoMachine.LottoType.BONUS, 1);
    }

    @Test
    public void 로또결과를_생성할수있다() {
        assertThat(lottoResult).isNotNull();
    }

    @Test
    public void 당첨금액을_알수있다() {
        // 5개 일치, 보너스 볼 일치(30000000원) * 1개
        assertThat(lottoResult.reward()).isEqualTo(30_000_000);
    }
}