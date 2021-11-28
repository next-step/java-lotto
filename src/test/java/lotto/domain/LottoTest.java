package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private List<Integer> prizeNumbers;

    @BeforeEach
    void setUp() {
        prizeNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("Numbers를 받는 생성자로 Lotto를 생성한다.")
    @Test
    void create() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(new Numbers(numbers)).getNumbers()).isInstanceOf(Numbers.class);
    }


    @DisplayName("countMatch 함수는 Lotto Numbers 가 prizeNumbers 와 일치하는 수를 반환한다.")
    @Test
    public void countMatch() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(6);

        numbers = Arrays.asList(1, 2, 3, 4, 5, 45);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(5);

        numbers = Arrays.asList(1, 2, 3, 4, 44, 45);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(4);

        numbers = Arrays.asList(1, 2, 3, 43, 44, 45);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(3);

        numbers = Arrays.asList(1, 2, 42, 43, 44, 45);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(2);

        numbers = Arrays.asList(1, 22, 42, 43, 44, 45);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(1);

        numbers = Arrays.asList(11, 22, 42, 43, 44, 45);
        assertThat(new Lotto(new Numbers(numbers)).countMatch(new Numbers(prizeNumbers))).isEqualTo(0);
    }
}
