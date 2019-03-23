package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumbesTest {

    @Test
    public void initLottoNumbersTest() {
        assertThat(new LottoNumbes().lottoNumber.size()).isEqualTo(6);
    }
}