package lotto.domain.lotto.count;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ManualCountTest {

    private Count totalCount;

    @BeforeEach
    void setUp() {
        totalCount = new Count(20);
    }

    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 20})
    @ParameterizedTest
    void 정상적인_구매_개수_확인(int value) {
        final ManualCount manualCount = new ManualCount(value, totalCount);
        assertThat(manualCount.getCountValue()).isEqualTo(value);
    }

    @ValueSource(strings = {"1", "2", "10", "0"})
    @ParameterizedTest
    void 정상적인_구매_개수_문자열일_경우_확인(String value) {
        final ManualCount manualCount = new ManualCount(value, totalCount);
        assertThat(manualCount.getCountValue()).isEqualTo(Integer.parseInt(value));
    }

    @ValueSource(strings = {"1,", "2개", "ㅇ100000", "50d0"})
    @ParameterizedTest
    void 정수로_변환_불가능한_입력값(String value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new ManualCount(value, totalCount)).withMessage("[ERROR] 숫자만 들어올 수 있습니다.");
    }

    @ValueSource(ints = {-1, -100, -342})
    @ParameterizedTest
    void 구매_개수가_0보다_작을_경우(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() ->  new ManualCount(value, totalCount)).withMessage("[ERROR] 구매 개수가 0보다 작을 수는 없습니다.");
    }

    @ValueSource(ints = {21, 100, 70})
    @ParameterizedTest
    void 구매_개수가_총_구매_개수보다_큰_경우(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new ManualCount(value, totalCount)).withMessage("[ERROR] "+totalCount.getValue()+"개를 초과할 수 없습니다.");
    }
}