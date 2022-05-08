package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTest {

    List<Number> numbers;

    @BeforeEach
    void beforeEach() {
        this.numbers = IntStream.range(1, 46)
                .mapToObj(Number::of)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("로또 생성")
    void createLotto() {
        assertThat(new Lotto().getNumbers()).hasSize(0);
    }

    @Test
    @DisplayName("로또 번호 자동 추첨")
    void autoDraw() {
        assertThat(Lotto.draw().getNumbers()).hasSize(6).containsAnyOf(this.numbers.toArray(new Number[0]));
    }

    @Test
    @DisplayName("번호 존재 여부 확인")
    void contains() {
        List<Number> numbers = this.numbers.subList(0, 6);

        assertAll(() -> assertThat(Lotto.draw(numbers).contains(Number.of(6))).isTrue(),
                () -> assertThat(Lotto.draw(numbers).contains(Number.of(7))).isFalse());
    }

    @Test
    @DisplayName("로또 당첨 결과 확인")
    void isWin() {
        List<Number> numbers = this.numbers.subList(0, 6);

        assertThat(Lotto.draw(numbers).contains(numbers)).isEqualTo(Number.of(6));
    }
}
