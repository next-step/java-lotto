package study.lotto.core;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {

    private static final LottoNumber bonusLottoNumber = LottoNumber.of(7);

    @Test
    void test_of_first() {
        // Given
        Set<LottoNumber> lottoNumbers = toLottoNumbers(new int[]{1, 2, 3, 4, 5, 6});
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers toWinLottoNumbers = toWinLottoNumbers(lottoNumbers, bonusLottoNumber);

        // When
        WinningLotto winningLotto = lotto.lottery(toWinLottoNumbers);

        // Then
        assertEquals(winningLotto.getLottoRank(), LottoRank.FIRST);
    }

    @Test
    void test_of_none() {
        // Given
        WinningLotto winningLotto = new WinningLotto(new ArrayList<>(), false);

        // When
        LottoRank lottoRank = LottoRank.of(winningLotto, false);

        // Then
        assertEquals(lottoRank, LottoRank.NONE);
    }

    @Test
    void test_of_second() {
        // Given
        Set<LottoNumber> lottoNumbers = toLottoNumbers(new int[]{1, 2, 3, 4, 5, 7});
        Set<LottoNumber> winLottoNumbers = toLottoNumbers(new int[]{1, 2, 3, 4, 5, 10});
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers toWinLottoNumbers = toWinLottoNumbers(winLottoNumbers, bonusLottoNumber);

        // When
        WinningLotto winningLotto = lotto.lottery(toWinLottoNumbers);

        // Then
        assertEquals(winningLotto.getLottoRank(), LottoRank.SECOND);
    }

    @Test
    void test_of_third() {
        // Given
        Set<LottoNumber> lottoNumbers = toLottoNumbers(new int[]{1, 2, 3, 4, 5, 6});
        Set<LottoNumber> winLottoNumbers = toLottoNumbers(new int[]{1, 2, 3, 4, 5, 10});
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers toWinLottoNumbers = toWinLottoNumbers(winLottoNumbers, bonusLottoNumber);

        // When
        WinningLotto winningLotto = lotto.lottery(toWinLottoNumbers);

        // Then
        assertEquals(winningLotto.getLottoRank(), LottoRank.THIRD);
    }

    private Set<LottoNumber> toLottoNumbers(int[] lottoNumbers) {
        List<LottoNumber> toLottoNumbers = new ArrayList<>();
        for (int value : lottoNumbers) {
            toLottoNumbers.add(LottoNumber.of(value));
        }
        return new HashSet<>(toLottoNumbers);
    }

    private WinLottoNumbers toWinLottoNumbers(Set<LottoNumber> winLottoNumbers, LottoNumber bonusLottoNumber) {
        return new WinLottoNumbers.WinLottoNumbersBuilder(winLottoNumbers)
                .bonusLottoNumber(bonusLottoNumber)
                .build();
    }
}