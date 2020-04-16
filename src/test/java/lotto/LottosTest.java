package lotto;

import lotto.domain.LottoGame;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setup() {
        lottoGame = new LottoGame();
    }

    @DisplayName("lotto 랜덤 값이 1~45 사이인지 테스")
    @Test
    void randomLimit() {
        Lottos lottos = new Lottos();
        int random = lottos.getRandom();
        assertThat(random).isBetween(1, 45);
    }

    @DisplayName("lotto 생성 테스트")
    @Test
    void createLottos() {
        Lottos lottos = new Lottos(15000);
        assertThat(lottos.getLottos().size()).isEqualTo(15);
    }
}
