package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.LottoNum;
import step2.domain.Winning;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step2.util.LottoNumberUtils.of;

class WinningTest {
    @Test
    @DisplayName("유효한 당첨번호")
    void valid() {
        Winning winning = new Winning(of(1,3,4,5,6,8));
        assertThat(winning.get()).hasSize(6);
    }

    @ParameterizedTest
    @MethodSource("provideSets")
    @DisplayName("무효한 당첨번호")
    void invalid(Set<LottoNum> set) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Winning(set));
    }

    static Stream<Set<LottoNum>> provideSets() {
        return Stream.of(
                of(1,3,4,5,6,7,8),
                of(1,3,4,5,6));
    }
}
