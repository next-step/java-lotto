package step2.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.domain.LottoNumberMachine.*;

public class LottoGameTest {

    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(new Request(5000));
    }

    @Test
    @DisplayName("로또 구매 테스트")
    void buyLottoTest() {
        assertThat(lottoGame.getLotto().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 제공 테스트")
    void lottoNumberTest() {
        assertThat(provideLottoNumber().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨 테스트")
    void winLottoTest() {
        // given
        Lotto<Integer> lotto = new Lotto<>();
        lotto.addLottoNumber(new LottoNumbers<>(Arrays.asList(1, 10, 20, 30, 40, 45)));
        lotto.addLottoNumber(new LottoNumbers<>(Arrays.asList(2, 12, 20, 30, 41, 45)));
        lotto.addLottoNumber(new LottoNumbers<>(Arrays.asList(2, 12, 22, 32, 41, 42)));

        List<Integer> target = Arrays.asList(1, 10, 20, 30, 40, 45);

        // then
        assertThat(lotto.getWinLotto(target)).containsValues(Arrays.asList(Rank.FIFTH), Arrays.asList(Rank.FIRST));
    }
}