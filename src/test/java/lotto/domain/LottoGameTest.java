package lotto.domain;

import lotto.domain.lotto.Lottos;
import lotto.domain.wrapper.Numbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("로또 구매의 총 수익률을 계산한다.")
    @Test
    void calculateProfitRate() {
        // given
        List<Numbers> numberses = List.of(
            new Numbers(List.of(1, 5, 12, 21, 33, 45)),
            new Numbers(List.of(2, 6, 13, 22, 34, 45)),
            new Numbers(List.of(1, 5, 13, 24, 31, 44)),
            new Numbers(List.of(3, 7, 15, 22, 32, 43))
        );

        LottoGame lottoGame = new LottoGame();
        lottoGame.createLottos(numberses);

        long purchase = 135000;
        Numbers winningNumbers = new Numbers(List.of(1, 5, 12, 21, 32, 43));

        // when
        double profitRate = lottoGame.calculateProfitRate(purchase, winningNumbers);

        // then
        assertThat(profitRate).isEqualTo(0.37);
    }
}