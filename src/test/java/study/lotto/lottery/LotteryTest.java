package study.lotto.lottery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.*;
import study.lotto.dispenser.Lottos;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void init() {
        this.lottoNumbers = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }

    @Test
    @DisplayName("1등 당첨")
    void test_lottery_first() {
        // Given
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers winLottoNumbers = new WinLottoNumbers(lottoNumbers);

        // When
        WinningLotto lottery = lotto.lottery(winLottoNumbers);

        // Then
        int matchingNumberCount = lottery.getMatchingNumberCount();

        assertEquals(matchingNumberCount, 6);
        assertEquals(lottery.getLottoRank(), LottoRank.FIRST);
        assertEquals(lotto.getLottoStatus(), LottoStatus.HAS_BEEN_LOTTERY);
    }

}