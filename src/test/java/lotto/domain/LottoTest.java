package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("중복된 숫자가 있으면 예외가 발생한다.")
    void duplicate() {
        List<Integer> lottoNumbers = Arrays.asList(1, 1, 1, 1, 1, 1);
        Assertions.assertThatThrownBy(() -> {
            new Lotto(lottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 사이즈는 6이 아니면 예외가 발생한다.")
    void size() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Assertions.assertThatThrownBy(() -> {
            new Lotto(lottoNumbers1);
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> {
            new Lotto(lottoNumbers2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또와 당첨 로또의 값을 비교하여 count를 반환한다")
    void match() {
        List<Integer> lottoNumbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> lottoNumbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(lottoNumbers1);
        Lotto lotto2 = new Lotto(lottoNumbers2);

        Assertions.assertThat(lotto1.match(lotto2)).isEqualTo(6);
    }
}