package lotto;

import lotto.domain.LotteryNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"34", "2", "7", "1", "45"})
    @DisplayName("정상적으로 생성 되는지 테스트")
    void create(int value) {
        LotteryNumber lotteryNumber = new LotteryNumber(value);
        assertThat(lotteryNumber.getValue()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"200", "0", "-1", "46"})
    @DisplayName("로또번호가 범위를 넘어간 숫자로 생성시 예외 발생 테스트")
    void create_with_out_of_range_value(int value) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new LotteryNumber(value));
    }
}
