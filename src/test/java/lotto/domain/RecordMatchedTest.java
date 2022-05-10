package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecordMatchedTest {

    @Test
    @DisplayName("일급 컬렉션 상태 확인")
    void test() {
        RecordMatched recordMatched = new RecordMatched(Matched.values().length);
        int[] recordMatchedArray = {1, 0, 0, 0, 0, 0, 0, 0};
        assertThat(recordMatched.addByMatchedIndex(0)).isEqualTo(new RecordMatched(recordMatchedArray));
    }
}