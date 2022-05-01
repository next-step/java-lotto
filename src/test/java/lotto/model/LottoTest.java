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
                .mapToObj(Number::new)
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
        Lotto lotto = new Lotto();
        lotto.draw();

        assertThat(lotto.getNumbers()).hasSize(6).containsAnyOf(this.numbers.toArray(new Number[0]));
    }

    @Test
    @DisplayName("번호 존재 여부 확인")
    void contains() {
        Lotto lotto = new Lotto();
        List<Number> numbers = this.numbers.subList(0, 6);

        assertAll(() -> assertThat(lotto.draw(numbers).contains(new Number(6))).isTrue(),
                () -> assertThat(lotto.draw(numbers).contains(new Number(7))).isFalse());
    }

    @Test
    @DisplayName("로또 당첨 결과 확인")
    void isWin() {
        Lotto lotto = new Lotto();
        List<Number> numbers = this.numbers.subList(0, 6);

        assertThat(lotto.draw(numbers).contains(numbers)).isEqualTo(6);
    }
}
