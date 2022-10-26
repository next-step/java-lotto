package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoAmountTest {
    @Test
    @DisplayName("로또 가격을 문자열로 입력받아도 로또가격은 생성 가능하다.")
    void inputStringLottoAmount_isEqualToIntegerLottoAmount() {
        assertThat(new LottoAmount("14000")).isEqualTo(new LottoAmount(14000));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "1", "1234", "/"})
    @DisplayName("로또 가격이 정수가 아닌 유효하지 않은 값으로 입력되었을 때 에러 발생한다.")
    void inputStringLottoAmount_throwsIllegalArgumentException(String input) {
        assertThatThrownBy(() -> new LottoAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 가격을 입력 받고 구입 받을 수 있는 로또의 개수를 알 수 있다.")
    void calcLottoAmount_isEqualToLottoCount() {
        assertThat(new LottoAmount("14000").calcLottoCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 수익률 구할 수 있다.")
    void calcLottoWinningRateTest() {
        int sum = 5000;
        assertThat(new LottoAmount("6000").calcSumWinningMoneyRate(sum)).isEqualTo(0.83);
    }

}
