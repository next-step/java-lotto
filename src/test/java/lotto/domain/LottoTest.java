package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void create() {
        Lotto lotto = new Lotto(() -> List.of(3, 10, 5, 20, 43, 31));
        assertThat(lotto).isEqualTo(new Lotto(List.of(3,10,5,20,43,31)));
    }

    @DisplayName("두 장의 로또에서 매칭된 숫자 개수를 반환한다")
    @Test
    void matchedCount() {
        Lotto lotto1 = new Lotto(() -> List.of(3, 10, 5, 20, 43, 31));
        Lotto lotto2 = new Lotto(() -> List.of(3, 10, 5, 20, 1, 2));

        assertThat(lotto1.matchedCount(lotto2)).isEqualTo(4);
    }
}