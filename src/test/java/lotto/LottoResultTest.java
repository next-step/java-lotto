package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMatch;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("올바른 로또 결과를 반환한다")
    @Test
    void 로또_결과_반환() {
        List<Integer> list1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> list2 = List.of(3, 5, 11, 16, 32, 38);
        List<Integer> list3 = List.of(7, 11, 16, 35, 36, 44);

        Lotto lotto1 = new Lotto(list1);
        Lotto lotto2 = new Lotto(list2);
        Lotto lotto3 = new Lotto(list3);

        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3));

        WinningNumber winningNumber = new WinningNumber(List.of(2, 3, 4, 5, 16, 7), 10);

        LottoResult lottoResult = new LottoResult(lottos, winningNumber);

        Map<LottoMatch, Integer> resultMap = lottoResult.getResult();

        assertThat(resultMap)
                .containsEntry(LottoMatch.THREE_MATCH, 1)
                .containsEntry(LottoMatch.FOUR_MATCH, 0)
                .containsEntry(LottoMatch.FIVE_MATCH, 0)
                .containsEntry(LottoMatch.FIVE_BONUS_MATCH, 0)
                .containsEntry(LottoMatch.SIX_MATCH, 0);
    }
}
