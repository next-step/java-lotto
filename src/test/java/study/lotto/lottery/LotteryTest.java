package study.lotto.lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    @DisplayName("1등 당첨")
    void test_lottery_first() {
        // Given
        Lotto lotto = new Lotto(createLottoNumbers());
        WinLottoNumbers winLottoNumbers = new WinLottoNumbers(createLottoNumbers());
        Lottery lottery = new Lottery(winLottoNumbers, Arrays.asList(lotto));

        // When
        lottery.checkLotto();

        // Then
        int matchingNumberCount = lotto.getMatchingNumberCount();

        assertEquals(matchingNumberCount, 6);
        assertEquals(lotto.getLottoRank(), LottoRank.FIRST);
        assertEquals(lotto.getLottoStatus(), LottoStatus.HAS_BEEN_LOTTERY);
    }

    private List<LottoNumber> createLottoNumbers() {
        return Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }

}