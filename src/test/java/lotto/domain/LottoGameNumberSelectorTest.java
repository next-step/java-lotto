package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoGameNumberSelectorTest {

    @DisplayName("랜덤한 6개의 수가 추출 되어여 함.")
    @Test
    void select_number_test() {
        assertThat(LottoNumberSelector.selectNumbers().size()).isEqualTo(6);
    }

    @DisplayName("1부터 45 사이 값만 나와야 함.")
    @RepeatedTest(100)
    void name() {
        List<Integer> selectedNumbers = LottoNumberSelector.selectNumbers();
        for (Integer number : selectedNumbers) {
            assertThat(number).isBetween(1, 45);
        }
    }

    @DisplayName("6개의 수가 중복되어 나올수가 없음.")
    @Test
    void do_not_allow_duplicate_number() {
        Set<Integer> set = new HashSet<>(LottoNumberSelector.selectNumbers());
        assertThat(set.size()).isEqualTo(6);
    }
}
