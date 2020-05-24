package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoGameTest {

    private LottoGame lottoGame = new LottoGame();
    private int[] winningNumbers;
    private int round = 1;

    @BeforeEach
    void setUp() {
        winningNumbers = new int[]{1, 2, 3, 4, 5, 6};
        lottoGame.add(round, winningNumbers);
    }

    @Test
    @DisplayName("로또 게임을 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_게임_생성_테스트() {
        assertThatCode(() -> new LottoGame()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 게임을 추가하고, 결과 값을 검증한다.")
    void 로또_게임_라운드_get_테스트() {
        List<Integer> getNumbers = lottoGame.get(round);
        assertThat(getNumbers).hasSize(winningNumbers.length);
    }
}
