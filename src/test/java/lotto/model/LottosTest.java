package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    WinnerNumbers winnerNumbers;
    List<Lotto> lottoList;
    Lottos lottos;

    @BeforeEach
    void setUp() {
        winnerNumbers = new WinnerNumbers(Set.of(1, 2, 3, 4, 5, 6));
        lottoList = List.of(
                new Lotto(Set.of(1, 3, 4, 6, 9, 11)),
                new Lotto(Set.of(1, 2, 3, 4, 9, 11))
        );
        lottos = new Lottos(lottoList);
    }

    @Test
    @DisplayName("총 구입금액을 올바르게 리턴한다.")
    void test1() throws Exception {
        assertThat(lottos.totalPurchasePrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("당첨 번호와 가지고 있는 로또가 몇개 일치하는지 리턴한다")
    void test2() throws Exception {
        int correctCount = 4;
        assertThat(lottos.correctCount(winnerNumbers, correctCount))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("로또 갯수를 리턴한다.")
    void test3() throws Exception {
        assertThat(lottos.lottoCount()).isEqualTo(2);
    }
}