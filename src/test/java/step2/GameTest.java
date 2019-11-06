package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private Game game;
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        game = new Game();
        numbers = Arrays.stream(game.getNumbers().split(",")).map(num -> Integer.parseInt(num.trim())).collect(toList());
    }

    @Test
    @DisplayName("중복이 허용하지 않는 랜덤 숫자 6개가 생성되는지 확인")
    void createNumberTest() {
        assertThat(numbers.size()).isEqualTo(6);

    }

    @Test
    @DisplayName("구입한 로또가 오름차순인지 확인")
    void createGameTest() {
        assertAll(
                () -> assertTrue(numbers.get(0) < numbers.get(1)),
                () -> assertTrue(numbers.get(1) < numbers.get(2)),
                () -> assertTrue(numbers.get(2) < numbers.get(3)),
                () -> assertTrue(numbers.get(3) < numbers.get(4)),
                () -> assertTrue(numbers.get(4) < numbers.get(5))
        );
    }


}
