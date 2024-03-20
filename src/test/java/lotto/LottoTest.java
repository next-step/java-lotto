package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("도메인 Lotto 테스트")
class LottoTest {

    @DisplayName("Lotto 생성자 빈값 예외 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void validEmpty(List<Integer> input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(input))
                .withMessageMatching("입력값이 없습니다");
    }

    @DisplayName("Size 편의 메서드 테스트")
    @Test
    void size() {
        Lotto givenLotto = new Lotto(List.of(1, 2, 3));
        int result = givenLotto.size();
        assertThat(result).isEqualTo(3);
    }
}
