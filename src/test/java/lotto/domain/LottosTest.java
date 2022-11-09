package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 생성")
    @Test
    void createTest() {
        Lottos lottos = new Lottos(
                List.of(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(List.of(1, 2, 4, 9, 10, 40)),
                    new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));

        assertThat(lottos.getCount()).isEqualTo(3);
    }

    @DisplayName("각 로또의 번호와 당첨 번호와 일치한 개수 구하기")
    @Test
    void getAccordanceCountsTest() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 4, 9, 10, 40)),
                new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        List<Long> result = lottos.getAccordanceCounts(winningNumbers);

        assertThat(result).contains(6L, 3L, 3L);
    }

}