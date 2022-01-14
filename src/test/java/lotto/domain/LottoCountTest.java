package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoCountTest {

    private static final String INVALID_MANUAL_COUNT = "수동으로 구매할 로또의 갯수가 전체 로또의 갯수보다 많습니다.";

    @ParameterizedTest
    @CsvSource({"2,1,1", "3,1,2", "4,2,2"})
    void lotto_count_create_with_valid_count(int totalCount, int manualCount, int autoCount) {
        //given

        //when
        LottoCount lottoCount = new LottoCount(totalCount, manualCount);

        //then
        assertEquals(lottoCount.getAutoCount(), autoCount);
        assertEquals(lottoCount.getManualCount(), manualCount);
    }

    @ParameterizedTest
    @CsvSource({"33,90", "2,9", "4,5"})
    void manual_count_greater_than_total_count_is_invalid(int totalCount, int manualCount) {
        assertThatThrownBy(() -> new LottoCount(totalCount, manualCount))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining(INVALID_MANUAL_COUNT);
    }
}