package step2.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @DisplayName("로또 번호 중복 입력 검증")
    @Test
    void validateDuplicateLottoNumbers() {
        // given
        List<Integer> duplicateLottoNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        Assertions.assertThatThrownBy(() -> new Lotto(duplicateLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("규칙을 만족하지 않는 숫자 입력입니다");
    }
}
