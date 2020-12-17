package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static step2.LottoNumberGenerator.*;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame(new Request(5000));
    }

    @Test
    @DisplayName("로또(자동) 구매 테스트")
    void buyLottoTest() {
        assertThat(lottoGame.getLotto().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 제공 테스트")
    void lottoNumberTest() {
        assertThat(provideLottoNumbers().size()).isEqualTo(6);
    }
}
