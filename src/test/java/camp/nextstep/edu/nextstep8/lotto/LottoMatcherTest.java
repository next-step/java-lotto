package camp.nextstep.edu.nextstep8.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMatcherTest {
    @DisplayName("로또 추첨 결과가 잘 나오는지 확인")
    @Test
    public void matchTest() {
        // given
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(generateLottoNumber("1,2,3,4,5,6"));
        lottoNumbers.add(generateLottoNumber("1,2,3,4,5,16"));
        lottoNumbers.add(generateLottoNumber("1,2,3,4,15,16"));
        lottoNumbers.add(generateLottoNumber("1,2,3,14,15,16"));
        lottoNumbers.add(generateLottoNumber("1,2,13,14,15,16"));
        lottoNumbers.add(generateLottoNumber("1,12,13,14,15,16"));
        lottoNumbers.add(generateLottoNumber("11,12,13,14,15,16"));

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber("1,2,3,4,5,6");
        long totalReward = Arrays.stream(LottoAward.values()).mapToLong(e -> e.getPrize()).sum();

        // when
        LottoWinningResult result = LottoMatcher.match(lottoTicket, lottoWinnerNumber);

        // then
        assertAll(
                () -> assertThat(result.getWinningCount(LottoAward.FIRST)).isEqualTo(1),
                () -> assertThat(result.getWinningCount(LottoAward.SECOND)).isEqualTo(1),
                () -> assertThat(result.getWinningCount(LottoAward.THIRD)).isEqualTo(1),
                () -> assertThat(result.getWinningCount(LottoAward.FOURTH)).isEqualTo(1),
                () -> assertThat(result.getTotalReward()).isEqualTo(totalReward)
        );
    }

    private LottoNumber generateLottoNumber(String lottoNumberStr) {
        return new LottoNumber(lottoNumberStr);
    }
}
