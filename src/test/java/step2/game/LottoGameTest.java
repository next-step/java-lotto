package step2.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    private LottoGame lottoGame;
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        String lottoNumbers = lottoGame.toString();
        numbers = Arrays.stream(lottoNumbers.trim()
                .split(","))
                .map(num -> Integer.parseInt(num.trim()))
                .collect(toList());
    }

    @Test
    @DisplayName("중복이 허용하지 않는 랜덤 숫자 6개가 생성되는지 확인")
    void createNumberTest() {
        assertThat(numbers.size()).isEqualTo(6);
    }

}
