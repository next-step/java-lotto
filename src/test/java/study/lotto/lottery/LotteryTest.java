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

    private static final LottoNumber bonusLottoNumber = LottoNumber.of(7);
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void init() {
        this.lottoNumbers = Arrays.asList(LottoNumber.of(1)
                , LottoNumber.of(2)
                , LottoNumber.of(3)
                , LottoNumber.of(4)
                , LottoNumber.of(5)
                , LottoNumber.of(6));
    }

    @Test
    @DisplayName("1등 당첨")
    void test_lottery_first() {
        // Given
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers winLottoNumbers = new WinLottoNumbers(lottoNumbers, bonusLottoNumber);

        // When
        WinningLotto lottery = lotto.lottery(winLottoNumbers);

        // Then
        int matchingNumberCount = lottery.getMatchingNumberCount();

        assertEquals(matchingNumberCount, 6);
        assertEquals(lottery.getLottoRank(), LottoRank.FIRST);
    }

}