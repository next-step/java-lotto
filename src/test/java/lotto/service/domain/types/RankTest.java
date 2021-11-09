package lotto.service.domain.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RankTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    @DisplayName("Rank 정상 생성여부")
    void valueOf(int countOfMatch) {
        Rank rank = Rank.valueOf(countOfMatch);
        assertThat(rank).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7, 8, 9})
    @DisplayName("잘못된 숫자 입력 시, 예외발생")
    void valueOf_exception(int countOfMatch) {
        assertThatIllegalArgumentException().isThrownBy(() -> Rank.valueOf(countOfMatch));
    }
}
