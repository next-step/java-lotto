package lotto_auto.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    @DisplayName("음수를 입력 받으면 예외 발생 테스트")
    @Test
    public void enterNegativeValueExceptionTest() {
        LottoStore lottoStore = new LottoStore();

        assertThatThrownBy(
                () -> lottoStore.buy(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoBundle 생성 테스트")
    @Test
    public void returnLottoBundleTest() {
        LottoStore lottoStore = new LottoStore();
        LottoBundle lottoBundle = lottoStore.buy(1000);
        assertThat(lottoBundle).isNotNull();
    }
}
