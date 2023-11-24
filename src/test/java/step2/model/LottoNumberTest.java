package step2.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.model.LottoNumber;

public class LottoNumberTest {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    @Test
    void 로또번호는_숫자가_같으면_같다() {
        LottoNumber lottoNumber1 = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(1);
        assertThat(lottoNumber1).isEqualTo(lottoNumber2);
    }
    @ParameterizedTest
    @ValueSource(ints = {MIN_LOTTO_NUMBER - 1, MAX_LOTTO_NUMBER + 1})
    public void 범위를_벗어난_로또숫자_전달_시_예외_테스트(int givenLottoNumber) {
        assertThatThrownBy(() -> LottoNumber.of(givenLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
