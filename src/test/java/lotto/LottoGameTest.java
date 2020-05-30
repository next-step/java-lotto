package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoGameTest {

    private LottoGame lottoGame = new LottoGame();
    private int round = 1;

    @BeforeEach
    void setUp() {
        Set winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(LottoNumber::of).collect(Collectors.toSet());
        lottoGame.add(round, winningNumbers, 8);
    }

    @Test
    @DisplayName("로또 게임을 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_게임_생성_테스트() {
        assertThatCode(() -> new LottoGame()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또 게임을 추가하고, 결과 값을 검증한다.")
    void 로또_게임_라운드_get_테스트() {
        WinningLotto winningLotto = lottoGame.get(round);
        assertThat(winningLotto).isNotNull();
    }
}
