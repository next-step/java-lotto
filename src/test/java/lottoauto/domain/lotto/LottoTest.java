package lottoauto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("입력 받은 당첨번호를 통해 몇 개의 번호가 일치하는지 알려줍니다.")
    void getMatchCount() {
        // given
        List<Integer> winnerNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        // when
        int lottoScore = lotto.getLottoScore(winnerNumbers);
        // then
        assertThat(lottoScore).isEqualTo(3);
    }

}