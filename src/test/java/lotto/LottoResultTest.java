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
    }

    @Test
    void 특정개수맞춘티켓이_최초면_1를_추가한다() {
        lottoResult.add(COUNT_OF_CORRECT_NUMBER);

        assertThat(lottoResult.numOf(COUNT_OF_CORRECT_NUMBER)).isEqualTo(1);
    }

    @Test
    void 특정개수맞춘티켓이_이미존재하면_1를_추가한다() {
        lottoResult.add(COUNT_OF_CORRECT_NUMBER);
        lottoResult.add(COUNT_OF_CORRECT_NUMBER);

        assertThat(lottoResult.numOf(COUNT_OF_CORRECT_NUMBER)).isEqualTo(2);
    }
}
