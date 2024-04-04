package lotto.domain;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    @DisplayName("로또 생성 테스트")
    public void lottoInitializationTest() {
        Lotto lotto = new Lotto(Arrays.asList(2, 4, 5, 8, 10, 42));

        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 생성 오류 테스트 - 정해진 숫자 갯수 초과 시")
    public void lottoInitializationOverLengthTest() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(2, 4, 6, 13, 23, 39, 45)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR);
    }

    @Test
    @DisplayName("로또 생성 로튜 세트 - 정해진 숫자 범위 벗어날 경우")
    public void lottoInitializationRangeErrorTest() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(2, 3, 10, 49, 30, 23)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NUMBER_BOUND_ERROR);
    }
}