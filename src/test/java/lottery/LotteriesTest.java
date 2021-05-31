package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteriesTest {

    @Test
    @DisplayName("입력한 개수만큼 로또를 생성한다.")
    void generateLotteries_test() {
        //when
        Lotteries lotteries = new Lotteries(5, new MockNumberGenerator());

        //then
        assertThat(lotteries.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -20})
    @DisplayName("로또 생성 개수가 1개미만인 경우 예외처리한다.")
    void validateGenerateCount_test(int count) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotteries(count, new MockNumberGenerator()));
    }

}
