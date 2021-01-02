package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoCoinTest {

    private LottoCoin lottoCoin;

    @BeforeEach
    void setUp() {
        lottoCoin = new LottoCoin();
    }

    @Test
    @DisplayName("코인 생성 테스트")
    void name() {
        lottoCoin.coinCharge();
        assertThat(lottoCoin.getCoin()).isEqualTo(1);
    }
}