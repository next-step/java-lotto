package lotto.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    void 로또자동발급확인() {
        Lotto lotto = Lotto.autoGenerate();
        assertThat(lotto.numbers().getValues().size()).isEqualTo(6);
        assertAll(
                () -> assertThat(Numbers.NUMBER_RANGE.contains(lotto.numbers().find(0))).isTrue(),
                () -> assertThat(Numbers.NUMBER_RANGE.contains(lotto.numbers().find(1))).isTrue(),
                () -> assertThat(Numbers.NUMBER_RANGE.contains(lotto.numbers().find(2))).isTrue(),
                () -> assertThat(Numbers.NUMBER_RANGE.contains(lotto.numbers().find(3))).isTrue(),
                () -> assertThat(Numbers.NUMBER_RANGE.contains(lotto.numbers().find(4))).isTrue(),
                () -> assertThat(Numbers.NUMBER_RANGE.contains(lotto.numbers().find(5))).isTrue()
        );
    }
}
