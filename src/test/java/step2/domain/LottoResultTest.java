package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또결과")
public class LottoResultTest {

    @Test
    public void isWinningNumbersCount() {
        LottoResult lottoResult = new LottoResult(3);
        assertThat(lottoResult.isWinningNumbersCount(3)).isTrue();
    }

}
