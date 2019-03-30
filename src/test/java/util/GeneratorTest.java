package util;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class GeneratorTest {
    private static final int MIN_LOTTO_NUMBER = 0;
    private static final int MAX_LOTTO_NUMBER = 45;

    @Test
    public void isLottoNumberTest() {
        Generator.lottoNumbers().forEach(lottoNumber -> {
            assertThat(isLottoNumber(lottoNumber)).isTrue();
        });
    }

    public boolean isLottoNumber(int number) {
        return number <= MAX_LOTTO_NUMBER && number >= MIN_LOTTO_NUMBER;
    }
}