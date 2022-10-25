package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "1990,1", "1999,1", "2001,2"})
    void 로또_금액에_따라_로또_발급횟수를_계산(int money, int terms) {
        assertThat(LottoStore.buyLottos(money).getSize()).isEqualTo(terms);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 1, 3, 0})
    void 천원_이하에_돈이_입력되면_오류를_출력(int money) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    LottoStore.buyLottos(money);
                });
    }
}
