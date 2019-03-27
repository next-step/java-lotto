package domain;

import org.junit.Before;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberGeneratorTest {
    private LottoNumberGenerator lottoNumberGenerator;

    @Before
    public void setUp() {
        lottoNumberGenerator = new LottoNumberGenerator();
    }
}
