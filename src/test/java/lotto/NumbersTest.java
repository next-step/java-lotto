package lotto;

import lotto.domain.Numbers;
import lotto.domain.NumbersGenerator;
import lotto.domain.NumbersSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @DisplayName("Lotto 전체 숫자로 초기화하는 클래스")
    @Test
    void numberGenertor() {
        // GIVE
        Numbers numbers = new NumbersGenerator();
        // WHEN
        int size = numbers.getNumbers().size();
        // THEN
        assertThat(size).isEqualTo(45);
    }

    @DisplayName("Lotto 지정 숫자로 초기화는 클래스")
    @Test
    void numberSelector() {
        // GIVE
        String[] number = {"1", "2", "3", "4", "5", "6"};
        Numbers numbers = new NumbersSelector(number);
        // WHEN
        int size = numbers.getNumbers().size();
        // THEN
        assertThat(size).isEqualTo(6);
    }
}
