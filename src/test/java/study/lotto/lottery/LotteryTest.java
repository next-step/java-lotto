package study.lotto.lottery;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryTest {

    private static final LottoNumber bonusLottoNumber = LottoNumber.of(7);
    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    @BeforeEach
    public void init() {
        this.lottoNumbers.add(LottoNumber.of(1));
        this.lottoNumbers.add(LottoNumber.of(2));
        this.lottoNumbers.add(LottoNumber.of(3));
        this.lottoNumbers.add(LottoNumber.of(4));
        this.lottoNumbers.add(LottoNumber.of(5));
        this.lottoNumbers.add(LottoNumber.of(6));
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