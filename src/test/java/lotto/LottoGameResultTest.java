package lotto;

import lotto.domain.LottoGameResult;
import lotto.domain.LottoNumbers;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.dto.LottoGameResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottoGameResultTest {

    public static final WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6");

    @Test
    @DisplayName("당첨된 lotto의 수를 반환한다.")
    void should_return_winning_lotto() {
        //Given
        Rank rank1 = winningNumber.getRank(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Rank rank2 = winningNumber.getRank(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoGameResult lottoGameResult = new LottoGameResult(Arrays.asList(rank1, rank2));

        //When
        LottoGameResultDto lottoGameResultDto = lottoGameResult.getRankCount(Rank.FIRST);

        //Then
        assertThat(lottoGameResultDto).isEqualTo(new LottoGameResultDto(Rank.FIRST, 2));
    }
}