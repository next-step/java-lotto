package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("6자리 테스트")
    @Test
    void numberDigitTest() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6, 7)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 숫자 범위 테스트")
    @Test
    void numberRangeTest() {
        assertThatThrownBy(() -> new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 6, 46)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 일치 개수 확인 테스트")
    @Test
    void matchCountTest() {
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(new LottoNumbers(1, 2, 3, 4, 5, 10));
        assertThat(lotto.matchCount(winningNumbers)).isEqualTo(5);
    }

    @Test
    void 로또_자동_구매_테스트() {
        List<Lotto> lottos = Lotto.puchaseAuto(5);

        assertThat(lottos).hasSize(5);
    }

    @Test
    void 로또_수동_구매_테스트() {
        List<String> lottoNumbers = List.of("1, 2, 3, 4, 5, 6");
        List<Lotto> lottos = Lotto.puchaseManual(lottoNumbers);

        assertThat(lottos).hasSize(1);
        assertThat(lottos.get(0)).isEqualTo(new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6")));
    }
}
