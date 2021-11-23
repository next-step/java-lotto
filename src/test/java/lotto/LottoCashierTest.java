package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCashierTest {

    private final LottoCashier lottoCashier = new LottoCashier();

    @ParameterizedTest
    @CsvSource(value = {"0,0", "500,0", "1000,1"})
    void pay(String moneyString, int lottoCount) {
        List<Lotto> lottos = lottoCashier.pay(moneyString);
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void payFail_nullAndEmpty(String moneyString) {
        assertThatThrownBy(() -> {
            lottoCashier.pay(moneyString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void payFail_negativeAndString(String moneyString) {
        assertThatThrownBy(() -> {
            lottoCashier.pay(moneyString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈이 아닙니다.");
    }
    
}
