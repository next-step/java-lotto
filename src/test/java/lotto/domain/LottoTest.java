package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또를 생성 할 수 있다.")
    @Test
    void createTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isNotNull();
    }

    @DisplayName("다른 로또와 몇개 일치 하는지 알 수 있다.")
    @Test
    void matchCountTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.matchCount(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }

    @DisplayName("내 로또와 특정 로또넘버의 일치 여부를 확인 할 수 있다.")
    @Test
    void isMatchTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.isMatch(new LottoNo(1))).isTrue();
    }

    @DisplayName("로또 번호 목록을 가져올 수 있다.")
    @Test
    void getLottoNumbersTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lotto.getLottoNumbers()).isEqualTo(new HashSet<>(lotto.getLottoNumbers()));
    }

    @DisplayName("로또 생성시 중복값 발생하면 예외처리한다.")
    @Test
    void invalidTest() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5))).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessage("lotto size is not 6");
    }

    @DisplayName("로또 생성 시 길이가 6이 아닌 경우 예외가 발생한다.")
    @Test
    void checkValidLengthTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .withMessage("lotto size is not 6");
    }
}
