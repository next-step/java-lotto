package com.lotto.game;

import com.lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @DisplayName("정상 구매 테스트")
    @ParameterizedTest
    @CsvSource({"10000, 10", "14000, 14", "1000, 1"})
    public void purchaseTest(int money, int expected) {
        //when
        Lottos lottos = Game.purchase(money);

        //then
        assertThat(lottos.size()).isEqualTo(expected);
    }
}
