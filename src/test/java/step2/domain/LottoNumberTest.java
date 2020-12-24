package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.exception.IsInvalidRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.domain.WinningLottery.WINNING_NUMBER_INVALID_RANGE;

public class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 객체 생성 테스트")
    void create() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(3));
    }

    @ParameterizedTest
    @DisplayName("올바른 범위의 로또 번호인지 테스트")
    @ValueSource(ints = {0, 46})
    void is_valid_number(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IsInvalidRangeException.class)
                .hasMessageContaining(WINNING_NUMBER_INVALID_RANGE);
    }

    @Test
    @DisplayName("현재 로또 번호와 당첨 복권의 로또 번호가 같은지 테스트")
    void compare_lotto_number() {
        LottoNumber lottoNumber = new LottoNumber(3);
        assertThat(lottoNumber.compareNumber(new LottoNumber(3)))
                .isEqualTo(1);
    }
}
