package lotto_auto.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoStoreTest {

    private LottoStore lottoStore;

    @BeforeEach
    public void test() {
        lottoStore = new LottoStore();
    }

    @DisplayName("음수를 입력 받으면 예외 발생 테스트")
    @Test
    public void enterNegativeValueExceptionTest() {
        assertThatThrownBy(
                () -> lottoStore.buy(-1)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("LottoBundle 생성 테스트")
    @Test
    public void returnLottoBundleTest() {
        LottoBundle lottoBundle = lottoStore.buy(1000);
        assertThat(lottoBundle).isNotNull();
    }
}
