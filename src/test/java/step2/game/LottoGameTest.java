package step2.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoGameTest {
    private LottoGame lottoGame;
    private List<Integer> numbers;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame();
        String lottoNumbers = lottoGame.toString();
        numbers = Arrays.stream(lottoNumbers.trim()
                .split(","))
                .map(num -> Integer.parseInt(num.trim()))
                .collect(toList());
        winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);


    }

    @Test
    @DisplayName("중복이 허용하지 않는 랜덤 숫자 6개가 생성되는지 확인")
    void createNumberTest() {
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동 로또 생성")
    void createManualLottoTest() {
        List<Number> numbers = IntStream.rangeClosed(1, 6).boxed().map(Number::valueOf).collect(toList());
        assertThat(LottoGame.ofManual(numbers)
                .matchWinningNumberCount(winningLotto))
                .isEqualTo(6);

    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1, 2, 3, 4, 5, 6, 7",
            "-10, 3, 4, 5, 6, 7",
            "1, 2",
            "1, 2, 3, 4, 5, 46"
    })
    @DisplayName("수동 로또 선택 시 유효성 검증")
    void ofManual(String inputNumbers) {
        assertThrows(IllegalArgumentException.class, () -> ManualGames.buy(Collections.singletonList(inputNumbers)));
    }
}
