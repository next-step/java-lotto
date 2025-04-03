package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoEarningTest {
    @Test
    @DisplayName("당첨 결과를 통해 총 수익과 수익률을 계산한다.")
    void constructorTest() {
        // given
        List<LottoNumber> winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6),  // 6개 일치 (1개)
                List.of(1, 2, 3, 4, 5, 7), // 5개 일치 + 보너스 일치 (1개)
                List.of(1, 2, 3, 4, 5, 10), // 5개 일치 (1개)
                List.of(1, 2, 3, 4, 9, 10), // 4개 일치
                List.of(1, 2, 3, 4, 40, 41),  // 4개 일치 (2개)
                List.of(1, 12, 13, 14, 15, 16) // 1개 일치 (1개)
        );
        int purchasePrice = 5000;

        // when
        LottoEarning lottoEarning = LottoEarning.from(winningLottoNumbers, lottos, purchasePrice);
        Map<Rank, Integer> result = lottoEarning.getResult();

        // then
        // Rank 갯수 검증
        assertEquals(1, result.getOrDefault(Rank.SIX_MATCH, 0));
        assertEquals(1, result.getOrDefault(Rank.FIVE_MATCH_BONUS, 0));
        assertEquals(1, result.getOrDefault(Rank.FIVE_MATCH, 0));
        assertEquals(2, result.getOrDefault(Rank.FOUR_MATCH, 0));
        assertEquals(1, result.getOrDefault(Rank.NO_MATCH, 0));

        // 수익 계산
        int expectedProfit =
                (Rank.SIX_MATCH.getPrize()) +
                        (Rank.FIVE_MATCH_BONUS.getPrize()) +
                        (Rank.FIVE_MATCH.getPrize()) +
                        (2 * Rank.FOUR_MATCH.getPrize());
        assertEquals(expectedProfit, lottoEarning.getProfit());

        // 수익률 계산
        double expectReturnRate = (double) expectedProfit / purchasePrice;
        assertEquals(expectReturnRate, lottoEarning.getReturnRate());
    }

}
