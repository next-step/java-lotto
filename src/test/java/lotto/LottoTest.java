package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @Test
    @DisplayName("정상 입력시 로또 객체 정상 생성")
    void create() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);

        Assertions.assertThatNoException()
                .isThrownBy(() -> new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또 번호가 6개 초과인 경우 예외를 던진다")
    void validateListSizeOverSix() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 6개 미만인 경우 예외를 던진다")
    void validateListSizeUnderSix() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);

        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 중복되면 안된다")
    void validateDuplicatedNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 1, 1);

        Assertions.assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두 로또에서 겹치는 번호 개수를 계산한다")
    void countMatchNumber() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto.countMatchNumber(winningNumbers)).isEqualTo(6L);
    }
}
