package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WinningLottoNumbersTest {
    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복이면 예외를 반환한다.")
    void validateDuplicationTest() {
        List<LottoNumber> winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(1);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 구매한 로또를 비교하여 몇개의 숫자가 동일한지 비교한다.")
    void constructorTest() {
        // given
        List<LottoNumber> winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(7);
        List<List<Integer>> lottos = List.of(
                List.of(1, 2, 3, 4, 5, 6),  // 6개 일치 (1개)
                List.of(1, 2, 3, 4, 5, 7), // 5개 일치 + 보너스 일치 (1개)
                List.of(1, 2, 3, 4, 5, 10), // 5개 일치 (1개)
                List.of(1, 2, 3, 4, 9, 10), // 4개 일치
                List.of(1, 2, 3, 4, 40, 41),  // 4개 일치 (2개)
                List.of(1, 12, 13, 14, 15, 16) // 1개 일치 (1개)
        );
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(winningNumbers, bonusNumber);

        // when
        Map<Rank, Integer> result = winningLottoNumbers.calculateResult(lottos);

        // then
        assertEquals(1, result.getOrDefault(Rank.SIX_MATCH, 0));
        assertEquals(1, result.getOrDefault(Rank.FIVE_MATCH_BONUS, 0));
        assertEquals(1, result.getOrDefault(Rank.FIVE_MATCH, 0));
        assertEquals(2, result.getOrDefault(Rank.FOUR_MATCH, 0));
        assertEquals(1, result.getOrDefault(Rank.NO_MATCH, 0));
    }


}
