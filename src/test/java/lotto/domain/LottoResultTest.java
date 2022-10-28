package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("5개가 일치하고 보너스 번호가 일치하면 2등")
    void getLottoNumberList() {

        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winners = List.of(1, 2, 3, 4, 5, 6);

        // when
        LottoResult lottoResult = new LottoResult(numbers);
        LottoResult winnerLottoResult = new LottoResult(winners, 7);

        // then
        assertThat(lottoResult.getMatchCount(winnerLottoResult)).isEqualTo(Rank.SECOND);
    }
}
