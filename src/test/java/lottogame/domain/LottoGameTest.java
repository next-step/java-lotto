package lottogame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoGameTest {
    private final static int TIME_OF_GAME = 3;

    private LottoGame lottoGame;
    private int price = 2000;
    private int price2 = 5000;
    private LottoPrice lottoPrice;
    private List<LottoNumber> lottoManual;
    LottoNumber dummy;

    @BeforeEach
    void setup() {
        lottoPrice = new LottoPrice(price2);
        lottoManual = new ArrayList<>();
        for (int i = 0; i < TIME_OF_GAME; ++i) {
            dummy = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
            lottoManual.add(dummy);
        }
    }

    @Test
    void CountOFLottoManual_check() {



        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    lottoGame = new LottoGame(price, lottoManual);
                });
    }

    @Test
    void CountOfLottoAuto_check() {
        LottoGame lottoGame = new LottoGame(price2,lottoManual);
        assertThat(lottoGame.getLotto().size()- lottoManual.size()).isEqualTo(2);
    }
}