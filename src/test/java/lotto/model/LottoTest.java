package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.model.LottosTest.lottoNumbers;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("성공 : 로또번호는 6개가 존재한다 (6개 입력)")
    void length_success() {
        assertThatCode(() -> new Lotto(new HashSet<>(
                toLottoSet(List.of(1, 2, 3, 4, 5, 6))))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("실패 : 로또번호는 6개가 존재한다 (7개 입력)")
    void length_fail() {
        assertThatThrownBy(() -> {
            new Lotto(new HashSet<>(toLottoSet(
                    List.of(1, 2, 3, 4, 5, 6, 7))));

        }).isInstanceOf(IllegalArgumentException.class);
    }

    private Set<LottoNumber> toLottoSet(List<Integer> testLotto) {
        return lottoNumbers(testLotto);
    }
}