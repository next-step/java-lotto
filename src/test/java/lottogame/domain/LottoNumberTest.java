package lottogame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    private LottoNumber lotto;

    @Test
    void lottoNumber_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
                });
    }

    @Test
    void lottoNumberOutOfBound_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 50));
                });
    }

    @Test
    void lottoNumberCount_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5));
                });
    }

    @Test
    void noInput_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList());
                });
    }

    @Test
    void inputMinus_check() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, -7));
                });
    }

}