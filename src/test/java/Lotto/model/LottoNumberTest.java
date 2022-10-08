package Lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {

    private static final int NOT_LOTTO_NUMBER = 46;
    private static final int NORMAL_LOTTO_NUMBER = 1;

    @Test
    @DisplayName("로또번호 생성자 테스트 적절하지 않은 로도번호로 생성.")
    public void constructorErrorTest() {
        assertThatThrownBy(() -> new LottoNumber(NOT_LOTTO_NUMBER)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성자 테스트 적절한 개수로 생성")
    public void constructorSuccessTest() {
        assertThat(new LottoNumber(NORMAL_LOTTO_NUMBER)).isEqualTo(new LottoNumber(NORMAL_LOTTO_NUMBER));
    }

}