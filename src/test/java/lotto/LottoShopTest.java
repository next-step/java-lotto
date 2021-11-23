package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    private final LottoShop shop = new LottoShop();

    @ParameterizedTest
    @CsvSource(value = {"0,0", "500,0", "1000,1"})
    void buy(String moneyString, int lottoCount) {
        List<Lotto> lottos = shop.buy(moneyString);
        assertThat(lottos.size()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void buyFail_nullAndEmpty(String moneyString) {
        assertThatThrownBy(() -> {
            shop.buy(moneyString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void buyFail_negativeAndString(String moneyString) {
        assertThatThrownBy(() -> {
            shop.buy(moneyString);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("돈이 아닙니다.");
    }

}
