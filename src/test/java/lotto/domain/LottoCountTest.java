package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoCountTest {
    @ParameterizedTest
    @ValueSource(ints = {900, 1500})
    @DisplayName("입력 값이 1000원 미만이거나 1000단위가 아닌 경우 예외 발생")
    void 로또_금액_1000단위(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoCount(input));
    }

    @Test
    @DisplayName("로또 금액 입력 시 구매 가능한 복권 개수 리턴")
    void 로또_복권_개수(){
        assertThat(new LottoCount(3000).getCount()).isEqualTo(3);
        assertThat(new LottoCount(12000).getCount()).isEqualTo(12);
    }

}