package lottogame.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    private LottoNumber lotto;

    @Test
    void 로또번호_유효성_체크_객수가_많을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
                });
    }

    @Test
    void 로또번호_유효성_체크_숫자범위를_넘어갔을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6, 50));
                });
    }

    @Test
    void 로또번호_유효성_체크_갯수_적은경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5));
                });
    }

    @Test
    void 로또번호_유효성_체크_입력내용이_없을때() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList());
                });
    }

    @Test
    void 로또번호_유효성_체크_음수일경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lotto = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, -7));
                });
    }
}