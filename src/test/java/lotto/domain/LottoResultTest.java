package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {
    @Test
    @DisplayName("당첨 번호와 구매한 로또를 비교하여 몇개의 숫자가 동일한지 비교한다.")
    void constructorTest() {
        List<LottoNumber> winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6),  // 6개 일치 (1개)
                List.of(1, 2, 3, 4, 5, 10), // 5개 일치 (1개)
                List.of(1, 2, 3, 4, 9, 10), // 4개 일치
                List.of(1, 2, 3, 4, 40, 41),  // 4개 일치 (2개)
                List.of(11, 12, 13, 14, 15, 16) // 0개 일치 (1개)
        );
        LottoResult lottoResult = LottoResult.from(winningNumbers, lottos);

        Map<Rank, Integer> result = lottoResult.getResult();

        assertEquals(1, result.getOrDefault(Rank.SIX_MATCH, 0));
        assertEquals(1, result.getOrDefault(Rank.FIVE_MATCH, 0));
        assertEquals(2, result.getOrDefault(Rank.FOUR_MATCH, 0));
        assertEquals(1, result.getOrDefault(Rank.NO_MATCH, 0));
    }
}
