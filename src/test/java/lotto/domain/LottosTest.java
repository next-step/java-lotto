package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또 생성")
    @Test
    void createTest() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 4, 9, 10, 40)),
            new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));

        assertThat(lottos.getCount()).isEqualTo(3);
    }

    @DisplayName("각 로또의 당첨 번호 개수와 보너스 볼 일치 여부 구하기")
    @Test
    void getAccordanceCountsTest() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(1, 2, 3, 4, 9, 40)),
            new Lotto(List.of(1, 2, 3, 12, 17, 30))
        ));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 9));
        LottoNumber lottoNumber = new LottoNumber(6);

        List<Accordance> result = lottos.getAccordances(winningNumbers, lottoNumber);

        assertThat(result).contains(
            new Accordance(5, true),
            new Accordance(5, false),
            new Accordance(3, false)
        );
    }
}
