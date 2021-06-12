package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ManualLotteriesTest {


    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 5})
    @DisplayName("수동 로또인 경우 0개 미만이거나 총 로또개수를 초과하면 안된다.")
    void validateManualLotteriesCount_test(int countOfManualLotteries) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ManualLotteries.validateGenerateCount(4, countOfManualLotteries)
        );
    }
}
