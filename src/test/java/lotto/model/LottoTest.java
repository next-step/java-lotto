package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Number[] numbers;

    @BeforeEach
    void beforeEach() {
        this.numbers = IntStream.range(0, 46)
                .mapToObj(index -> new Number(index + 1))
                .toArray(Number[]::new);
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

        assertThat(lotto.getNumbers()).containsAnyOf(this.numbers);
    }

    @Test
    @DisplayName("로또 번호 수동 추첨")
    void manualDraw() {
        Lotto lotto = new Lotto();

        Set<Number> numberSet = Arrays.stream(this.numbers, 0, 6).collect(Collectors.toSet());
        Number[] choiceNumbers = Arrays.stream(this.numbers, 0, 6).toArray(Number[]::new);

        lotto.draw(numberSet);

        assertThat(lotto.getNumbers()).containsAnyOf(choiceNumbers);
    }
}
