package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("1부터 45 까지의 숫자가 아닐 경우 예외 발생")
    @Test
    void invalidNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 48)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("서로 중복된 숫자일 경우 예외 발생")
    @Test
    void duplicateNumbers() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 1, 1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 랜덤으로 생성")
    @Test
    void createRandomLotto() {
        List<Integer> lotto = new Lotto().getNumbers();
        assertThat(lotto).hasSize(LOTTO_SIZE);
        assertThat(lotto).doesNotHaveDuplicates();
    }

    @DisplayName("일치하는 로또 번호의 개수 구하기")
    @Test
    void getMatchCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = lotto.getMatchCount(winningLotto);
        assertThat(matchCount).isEqualTo(6);
    }

}