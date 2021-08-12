package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @ParameterizedTest(name = "당첨 번호와 일치하는 로또의 개수를 추출 할 수 있다.")
    @CsvSource(value = {"4,3,2,1", "0,0,0,0"})
    public void matchLottoNumbersTest(int threeMatches, int fourMatches, int fiveMatches, int sixMatches) {
        LottoTicket lottoTicket = createLottoTicket(threeMatches, fourMatches, fiveMatches, sixMatches);
        LottoNumbers winningLottoNumbers = createLottoNumbers(1,2,3,4,5,6);

        MatchResult matchResult = lottoTicket.match(winningLottoNumbers);
        assertThat(matchResult.countWinningLotteries(MatchCount.THREE)).isEqualTo(threeMatches);
        assertThat(matchResult.countWinningLotteries(MatchCount.FOUR)).isEqualTo(fourMatches);
        assertThat(matchResult.countWinningLotteries(MatchCount.FIVE)).isEqualTo(fiveMatches);
        assertThat(matchResult.countWinningLotteries(MatchCount.SIX)).isEqualTo(sixMatches);
    }

    private LottoTicket createLottoTicket(int threeMatches, int fourMatches, int fiveMatches, int sixMatches) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.addAll(Collections.nCopies(threeMatches, createLottoNumbers(1, 2, 3, 43, 44, 45)));
        lottoNumbers.addAll(Collections.nCopies(fourMatches, createLottoNumbers(1, 2, 3, 4, 44, 45)));
        lottoNumbers.addAll(Collections.nCopies(fiveMatches, createLottoNumbers(1, 2, 3, 4, 5, 45)));
        lottoNumbers.addAll(Collections.nCopies(sixMatches, createLottoNumbers(1, 2, 3, 4, 5, 6)));
        return LottoTicket.of(lottoNumbers);
    }

    private LottoNumbers createLottoNumbers(int... numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
        return LottoNumbers.of(lottoNumbers);
    }

}