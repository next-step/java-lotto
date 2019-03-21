package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoNumberTest {

    @Test
    public void initLottoNumbersTest() {
        assertThat(new LottoNumber().lottoNumber.size()).isEqualTo(6);
    }
}