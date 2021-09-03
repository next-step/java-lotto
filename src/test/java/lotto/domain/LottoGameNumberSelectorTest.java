package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameNumberSelectorTest {

    @DisplayName("랜덤한 6개의 수가 추출 되어여 함.")
    @Test
    void select_number_test() {
        LottoNumberRandomSelector lottoNumberRandomSelector = new LottoNumberRandomSelector();
        assertThat(lottoNumberRandomSelector.selectNumbers().size()).isEqualTo(6);
    }

    @DisplayName("6개의 수가 중복되어 나올수가 없음.")
    @Test
    void do_not_allow_duplicate_number() {
        LottoNumberRandomSelector lottoNumberRandomSelector = new LottoNumberRandomSelector();
        Set<Integer> set = new HashSet<>(lottoNumberRandomSelector.selectNumbers());
        assertThat(set.size()).isEqualTo(6);
    }
}
