package study.lotto.lottery;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.core.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LotteryTest {

    private List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
    private static final String bonusLottoNumber = "7";

    @Test
    @DisplayName("1등 당첨")
    void test_lottery_first() {
        // Given
        Lotto lotto = new Lotto(toLottoNumbers(lottoNumbers));
        WinLottoNumbers.WinLottoNumbersBuilder builder = new WinLottoNumbers.WinLottoNumbersBuilder(lottoNumbers);
        builder.bonusLottoNumber(bonusLottoNumber);
        WinLottoNumbers winLottoNumbers = builder.build();

        // When
        WinningLotto lottery = lotto.lottery(winLottoNumbers);

        // Then
        int matchingNumberCount = lottery.getMatchingNumberCount();

        assertEquals(matchingNumberCount, 6);
        assertEquals(lottery.getLottoRank(), LottoRank.FIRST);
    }

    private Set<LottoNumber> toLottoNumbers(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

}