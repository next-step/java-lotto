package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoCountTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 30, 4})
    @DisplayName("수동구매시 구매가능 개수가 아닐 경우 에러 발생")
    void 로또_수동_개수(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoCount(input, new LottoPrice(3000)));
    }

    @Test
    @DisplayName("수동구매 후 자동구매 개수 확인")
    void 로또_복권_개수() {
        assertThat(new LottoCount(3, new LottoPrice(3000)).getAutoLottoCount()).isEqualTo(0);
        assertThat(new LottoCount(0, new LottoPrice(3000)).getAutoLottoCount()).isEqualTo(3);
    }


}