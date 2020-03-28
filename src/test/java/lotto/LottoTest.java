package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(14);
    }

    @DisplayName("1~45 사이의 숫자 로또번호를 생성한다.")
    @Test
    void generateRandomNumbers() {
        List<Integer> numbers = lotto.generateRandomNumbers();
        assertThat(numbers).hasSize(6);
    }

}
