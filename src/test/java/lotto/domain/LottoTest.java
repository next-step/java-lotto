package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("로또에 숫자가 몇 개 포함되었는지 카운트한다.")
    @Test
    void getHits() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> other = List.of(1, 2, 3, 10, 11, 12);
        Lotto lotto = new Lotto(numbers);
        Lotto otherLotto = new Lotto(other);
        Assertions.assertThat(lotto.countHits(otherLotto)).isEqualTo(3);
    }

    @DisplayName("로또에 2등 보너스볼이 포함되어있는지 확인한다.")
    @Test
    void matchBonus() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        LottoNumber bonusNumber = new LottoNumber(6);
        Assertions.assertThat(lotto.matchBonus(bonusNumber)).isTrue();
    }

    @DisplayName("로또가 7자리 이상이면 오류이다.")
    @Test
    void lengthExceedException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7, 8)));
    }

    @DisplayName("로또에 중복되는 숫자가 있으면 오류이다.")
    @Test
    void duplicatedException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 7, 7)));
    }

    @DisplayName("로또에 46 이상의 숫자가 입력되면 오류이다.")
    @Test
    void exceed45Exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 7, 46)));
    }
}