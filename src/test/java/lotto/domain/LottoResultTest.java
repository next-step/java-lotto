package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @Test
    public void 로또결과_합계(){
        LottoResult lottoResult = new LottoResult(Rank.valueOf(3), 5);
        assertThat(lottoResult.sumResult()).isEqualTo(25000);
    }
}
