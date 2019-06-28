package lotto;

import lotto.domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    static public int COUNT_OF_CORRECT_NUMBER = 3;

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.add(COUNT_OF_CORRECT_NUMBER);
    }

    @Test
    void 특정개수맞춘티켓에대한_정보를_출력한다() {
        assertThat(lottoResult.getResultOf(3)).isEqualTo("3개 일치 (5000원)- 1개");
    }

    @Test
    void 수익률() {
        assertThat(lottoResult.getProfitRate()).isEqualTo(5);
    }
}
