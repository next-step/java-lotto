package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.dto.LottoInformation;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        LottoSeller autoLottoSeller = new AutoLottoSeller(() -> Lotto.of("4,5,6,7,8,9"));
        LottoSeller manualLottoSeller = new ManualLottoSeller();
        lottoGame = new LottoGame(autoLottoSeller, manualLottoSeller);
    }

    @DisplayName("LottoInformation으로 로또를 구매한다.")
    @Test
    void buy() {
        LottoInformation lottoInformation = new LottoInformation(Money.of(2000), Arrays.asList("1,2,3,4,5,6"));

        Lottos lottos = lottoGame.buy(lottoInformation);

        assertThat(lottos).isEqualTo(
                Lottos.of(Arrays.asList(
                        Lotto.of("1,2,3,4,5,6"),
                        Lotto.of("4,5,6,7,8,9")
                ))
        );
    }

}
