package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    @DisplayName("보너스 번호 테스트")
    void getLottoNumberList() {

        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        List<Integer> winners = List.of(1, 2, 3, 4, 5, 6);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers winnerLottoNumbers = new LottoNumbers(winners, 7);

        // then
        assertThat(lottoNumbers.getMatchCount(winnerLottoNumbers)).isEqualTo(Rank.SECOND);
    }
}
