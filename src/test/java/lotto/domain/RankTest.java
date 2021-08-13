package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RankTest {

    @ParameterizedTest(name = "MatchCount 는 0에서 6사이의 값이 아닌 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 7})
    public void MatchCountOfTest(int invalidCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Rank.valueOf(invalidCount))
                .withMessageContaining(String.valueOf(invalidCount));
    }

}