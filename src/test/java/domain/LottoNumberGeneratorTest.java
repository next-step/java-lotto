package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberGeneratorTest {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private LottoNumberGenerator lottoNumberGenerator;

    @Before
    public void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }

    @Test
    public void LOTTO_숫자_갯수_확인() {
        assertThat(lottoNumberGenerator.generateRandomNumber().getNumbers().size()).isEqualTo(LOTTO_NUMBER_SIZE);
    }
}
