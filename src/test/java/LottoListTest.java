import Lotto.constants.LottoPrize;
import Lotto.domain.LottoList;
import Lotto.domain.LottoNumber;
import Lotto.domain.Lotto;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoListTest {
    @Test
    void calculateStats_ShouldReturnCorrectCounts() {
        LottoList lottoList = new LottoList();
        Set<LottoNumber> winningNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        lottoList.addLotto(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        lottoList.addLotto(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(8), new LottoNumber(9))));

        Map<LottoPrize, Integer> stats = lottoList.calculateStats(winningNumbers);

        assertEquals(1, stats.getOrDefault(LottoPrize.THREE_MATCH, 0), "3개 일치하는 로또 개수는 1개여야 합니다.");
        assertEquals(1, stats.getOrDefault(LottoPrize.FOUR_MATCH, 0), "4개 일치하는 로또 개수는 1개여야 합니다.");
        assertEquals(0, stats.getOrDefault(LottoPrize.FIVE_MATCH, 0), "5개 이상 일치하는 로또가 없어야 합니다.");
        assertEquals(0, stats.getOrDefault(LottoPrize.SIX_MATCH, 0), "6개 일치하는 로또가 없어야 합니다.");
    }

    @Test
    void generateLottoNumbers_ShouldReturnSixUniqueNumbers() {
        List<LottoNumber> generatedNumbers = LottoList.generateLottoNumbers();
        assertEquals(6, generatedNumbers.size());
        assertTrue(generatedNumbers.stream().allMatch(n -> n.getNumber() >= 1 && n.getNumber() <= 45));
        assertEquals(generatedNumbers.size(), new HashSet<>(generatedNumbers).size()); // 중복 없는지 확인
    }
}
