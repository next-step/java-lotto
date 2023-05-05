package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottosTest {
    @Test
    @DisplayName("판매한 로또들의 선택 번호 정렬 반환")
    void numbers() {
        // given
        Lottos lottos = new Lottos(List.of(
                new Lotto(1, 6, 2, 5, 3, 4),
                new Lotto(11, 16, 12, 15, 13, 14)
        ));
        
        // when, then
        List<Set<Integer>> expectedNumbers = List.of(
                Set.of(1, 2, 3, 4, 5, 6),
                Set.of(11, 12, 13, 14, 15, 16)
        );
        assertThat(lottos.numbers()).isEqualTo(expectedNumbers);
    }
}