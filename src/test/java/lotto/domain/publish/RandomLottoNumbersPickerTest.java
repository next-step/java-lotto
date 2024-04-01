package lotto.domain.publish;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumbersPickerTest {

    @Test
    @DisplayName("무작위로 로또 번호 개수만큼의 번호를 추출한다.")
    void Pick_MainNumbers() {
        assertThat(new RandomLottoNumbersPicker().pickMain())
                .hasSize(LOTTO_NUMBERS_SIZE);
    }
}
