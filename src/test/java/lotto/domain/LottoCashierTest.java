package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCashierTest {

    private final LottoCashier lottoCashier = new LottoCashier();

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "1500,1"})
    void pay(int money, int lottoCount) {
        List<Lotto> lottos = lottoCashier.pay(money);
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500})
    void payFail(int money) {
        assertThatThrownBy(() -> {
            lottoCashier.pay(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 금액으로는 로또를 사실 수 없습니다.");
    }
    
}
