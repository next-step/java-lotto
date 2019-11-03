package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또를 생성한다.")
    void createLotto() {
        Lotto lotto = new Lotto();

        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).hasSize(6);
    }
}
