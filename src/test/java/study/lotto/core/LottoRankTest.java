package study.lotto.core;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoRankTest {

    private static final LottoNumber bonusLottoNumber = LottoNumber.of(7);

    @Test
    void test_of_first() {
        // Given
        List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        String bonusLottoNumber = "7";
        Set<LottoNumber> purchaseLottoNumbers = toLottoNumbers(lottoNumbers);
        Lotto lotto = new Lotto(purchaseLottoNumbers);
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
        List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "7");
        List<String> winLottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "10");
        String bonusLottoNumber = "7";
        Set<LottoNumber> purchaseLottoNumbers = toLottoNumbers(lottoNumbers);
        Lotto lotto = new Lotto(purchaseLottoNumbers);
        WinLottoNumbers toWinLottoNumbers = toWinLottoNumbers(winLottoNumbers, bonusLottoNumber);

        // When
        WinningLotto winningLotto = lotto.lottery(toWinLottoNumbers);

        // Then
        assertEquals(winningLotto.getLottoRank(), LottoRank.SECOND);
    }

    @Test
    void test_of_third() {
        // Given
        List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> winLottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "10");
        String bonusLottoNumber = "7";
        Set<LottoNumber> purchaseLottoNumbers = toLottoNumbers(lottoNumbers);
        Lotto lotto = new Lotto(purchaseLottoNumbers);
        WinLottoNumbers toWinLottoNumbers = toWinLottoNumbers(winLottoNumbers, bonusLottoNumber);

        // When
        WinningLotto winningLotto = lotto.lottery(toWinLottoNumbers);

        // Then
        assertEquals(winningLotto.getLottoRank(), LottoRank.THIRD);
    }

    private Set<LottoNumber> toLottoNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private WinLottoNumbers toWinLottoNumbers(List<String> winLottoNumbers, String bonusLottoNumber) {
        return new WinLottoNumbers.WinLottoNumbersBuilder(winLottoNumbers)
                .bonusLottoNumber(bonusLottoNumber)
                .build();
    }
}