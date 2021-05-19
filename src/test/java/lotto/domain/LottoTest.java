package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 자동생성 - 번호 자동생성됨")
    void generateAuto() {
        Lotto auto = Lotto.auto();

        List<Integer> numbers = auto.getNumbers();

        assertThat(numbers).hasSize(6);
    }
}
