package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoBuyerTest {

    LottoBuyer lottoBuyer;

    @BeforeEach
    void init() {
        lottoBuyer = new LottoBuyer(new LottoShop());
    }


    @Test
    @DisplayName("로또 구매량 테스트")
    void lotto_result_statistic_test() {
        lottoBuyer.buy(10000);
        lottoBuyer.generateNumbers(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoBuyer.getMyLotto()).hasSize(10);
    }


}