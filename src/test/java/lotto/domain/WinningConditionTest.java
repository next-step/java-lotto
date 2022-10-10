package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningConditionTest {

    @DisplayName("당첨 번호와 중복되는 보너스 볼 번호로 당첨 조건을 생성하면, 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void create_givenDuplicatedBonusNumber(int bonusNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningCondition(
                        Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoNumber(bonusNumber)
                ));
    }

}
