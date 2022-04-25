package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 상점")
class LottoStoreTest {

    @Test
    @DisplayName("돈과 로또 생성기로 로또 상점 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> LottoStore.of(100, RandomGenerator.getInstance()));
    }

    @Test
    @DisplayName("금액은 반드시 양수")
    void instance_negativeMoney_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoStore.of(-1, RandomGenerator.getInstance()));
    }

    @ParameterizedTest(name = "[{index}] {0}원으로 {1}개의 랜덤 로또 구매")
    @DisplayName("랜덤 로또 구매")
    @CsvSource({"500,0", "1000,1", "3000,3", "3500,3"})
    void randomLottoTickets(int money, int expectedSize) {
        assertThat(LottoStore.of(money, RandomGenerator.getInstance()).lottoTickets()
                .size())
                .isEqualTo(expectedSize);
    }
}
