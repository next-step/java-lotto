package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또(1~45 사이의 숫자 6개, 중복없음)를 생성합니다.")
    void test01() {
        List<Integer> lotto = LottoGenerator.generate();
        assertThat(lotto).hasSize(new HashSet<>(lotto).size());
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬한 리스트를 갖습니다.")
    void test02() {
        List<Integer> lotto = LottoGenerator.generate();
        assertThat(lotto).isSortedAccordingTo(naturalOrder());
    }

}