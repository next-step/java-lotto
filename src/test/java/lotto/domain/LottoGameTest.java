package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoGameTest {
    @DisplayName("구입금액을 입력하면 금액에 해당하는 로또가 발급된다.")
    @Test
    void lottoGameInit() {
        //given
        final LottoGame lottoGame = new LottoGame(new Amount(14500));

        //when
        final int result = lottoGame.purchaseCount();

        //then
        assertThat(result).isEqualTo(14);
    }

    @DisplayName("로또 금액보다 낮은 금액은 예외가 발생한다.")
    @Test
    void smallAmountTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoGame(new Amount(500));
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    void drawEmptyTest(String input) {
        final LottoGame lottoGame = new LottoGame(new Amount(14500));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoGame.draw(input, 10);
        });
    }

    @DisplayName("로또 번호 6개가 전부 일치하면 FIRST RANK를 가지는 Winning을 리턴한다.")
    @Test
    void drawTest() {
        //given
        final Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        final LottoGame lottoGame = new LottoGame(new Lottos(Arrays.asList(lotto)));

        //when
        final Winning winning = lottoGame.draw("1,2,3,4,5,6", 7);

        //then
        assertThat(winning).isEqualTo(new Winning(Map.of(Rank.FIRST, 1)));
    }
}