package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCountTest {

    @DisplayName("일치하는 로또 번호 수는 3, 4, 5, 6만 존재한다.")
    @ParameterizedTest
    @ValueSource(longs = {3,4,5,6})
    void matching_numbers_are_3_4_5_6(long given) {
        //when
        LottoCount result = new LottoCount(given);

        //then
        assertThat(result.getCount()).isEqualTo(given);
    }
}
