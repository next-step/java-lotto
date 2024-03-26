package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BonusMatchTest {

    @DisplayName("BonusMatch 생성자 테스트")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void constructor(boolean value) {
        assertThat(new BonusMatch(value).equals(value))
                .isTrue();
    }

}
