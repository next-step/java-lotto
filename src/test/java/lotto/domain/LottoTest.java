package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

public class LottoTest {

    @Test
    @DisplayName("[요구사항 1] 로또 번호 개수가 6개가 아닐 경우 IllegalArgumentException throw")
    void 요구사항_1() {
        // given
        Set<LottoNumber> lottoNumbers = Set.of(1, 2, 3, 4, 5).stream().map(LottoNumber::new).collect(Collectors.toSet());

        // then
        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개의 숫자로 구성되어야 합니다.");
    }
}
