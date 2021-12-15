package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 로또 정보 테스트")
class WinningLottoTest {
    private static final int WINNING_BONUS_NUMBER = 7;

    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))), new LottoNumber(WINNING_BONUS_NUMBER));
    }

    @DisplayName("당첨 로또 정보 생성")
    @Test
    void createTest() {
        // then
        assertThat(winningLotto).isNotNull();
    }

    @DisplayName("로또 당첨 순위 반환")
    @Test
    void matchTest() {
        // given
        Lotto purchasedLotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, WINNING_BONUS_NUMBER)));
        // when
        LottoRank secondLottoRank = winningLotto.match(purchasedLotto);
        // then
        assertThat(secondLottoRank).isEqualTo(LottoRank.SECOND);
    }
}
