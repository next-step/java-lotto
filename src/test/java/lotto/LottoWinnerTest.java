package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinnerTest {
    LottoNumber[] userLottoNumber = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().map(LottoNumber::from).toArray(LottoNumber[]::new);
    Lotto userLotto = Lotto.of(userLottoNumber);

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:FIRST", "1,2,3,4,5,7:6:SECOND", "1,2,3,4,5,7:8:THIRD", "1,2,3,4,7,8:9:FOURTH", "1,2,3,8,9,10:11:FIFTH", "9,10,11,12,13,14:15:MISS"}, delimiter = ':')
    public void matchingWinnerNumberTest_FIRST(String winnerNumber, int bonusNumber, String rank){
        LottoNumber[] winerLottoNumber = Arrays.stream(Arrays.stream(winnerNumber.split(",")).mapToInt(Integer::parseInt).toArray()).boxed().map(LottoNumber::from).toArray(LottoNumber[]::new);
        LottoNumber bonusLottoNumber = LottoNumber.from(bonusNumber);
        LottoTicket lottoTicket = LottoTicket.from(Arrays.asList(userLotto));
        LottoWinner lottoWinner = LottoWinner.of(winerLottoNumber, bonusLottoNumber);
        assertThat(lottoWinner.matchingWinnerNumber(lottoTicket)).contains(Rank.valueOf(rank));
    }

    @Test
    public void getMatchLottoCntTest() {
        LottoNumber[] winerLottoNumber = Arrays.stream(new int[]{1,2,3,4,5,6}).boxed().map(LottoNumber::from).toArray(LottoNumber[]::new);
        LottoNumber bonusLottoNumber = LottoNumber.from(7);
        LottoTicket lottoTicket = LottoTicket.from(Arrays.asList(userLotto));
        LottoWinner lottoWinner = LottoWinner.of(winerLottoNumber, bonusLottoNumber);
        lottoWinner.getMatchLottoCnt(lottoTicket.getLottoList().get(0));
    }
}
