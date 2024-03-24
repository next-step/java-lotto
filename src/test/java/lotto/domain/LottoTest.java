package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("매번 shuffle된 List가 생성된다")
    void shuffle_test() {
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();

        assertThat(lotto1.getAutoLotto()).isNotEqualTo(lotto2.getAutoLotto());
    }

    @Test
    @DisplayName("당첨번호와 일치 갯수를 판별할 수 있다")
    void matched_test() {
        List<Integer> winNo = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> lotto1 = List.of(1, 2, 3, 10, 20, 30);
        List<Integer> lotto2 = List.of(1, 2, 3, 4, 20, 30);
        List<Integer> lotto3 = List.of(10, 20, 30, 40, 12, 13);

        assertThat(new Lotto(lotto1).getMatchingCount(winNo)).isEqualTo(3);
        assertThat(new Lotto(lotto2).getMatchingCount(winNo)).isEqualTo(4);
        assertThat(new Lotto(lotto3).getMatchingCount(winNo)).isEqualTo(0);

    }
}
