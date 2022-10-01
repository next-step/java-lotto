package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoSellerTest {

    @ParameterizedTest
    @CsvSource(value = {"10000, 10", "55000,55"}, delimiter = ',')
    @DisplayName("구매금액으로 구매할 수 있는 로또 갯수 구하기")
    void get_lotto_count(int amount, int count) {
        assertThat(LottoSeller.getLottoCount(amount)).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100, 999, 1500, 9999})
    @DisplayName("거스름돈이 생기면 에러")
    void get_lotto_count_(int amount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoSeller.getLottoCount(amount));
    }

}