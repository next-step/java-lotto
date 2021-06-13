package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class GenerateCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -20})
    @DisplayName("자동 로또 생성 개수가 0개미만인 경우 예외처리한다.")
    void validateGenerateCount_test(int count) {
        //when
        assertThatIllegalArgumentException().isThrownBy(
                () -> GenerateCount.ofAutoLottery(count)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 5})
    @DisplayName("수동 로또인 경우 0개 미만이거나 총 로또개수를 초과하면 안된다.")
    void validateManualLotteriesCount_test(int countOfManualLotteries) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> GenerateCount.ofManualLottery(4, countOfManualLotteries)
        );
    }
}
