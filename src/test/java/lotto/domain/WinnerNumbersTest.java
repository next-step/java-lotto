package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinnerNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 당첨번호가_숫자_6개_아닌경우_IllegalArgumentException(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinnerNumbers(value, 45));
    }

    @Test
    void 당첨번호에_보너스번호와_동일한_숫자가_존재하면_IllegalArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinnerNumbers("1,2,3,4,5,6", 1));
    }

    @Test
    void 로또_당첨_결과_확인() {
        WinnerNumbers winnerNumbers = new WinnerNumbers("1,2,3,4,5,6", 45);
        Lotto matchOne = new Lotto("1,41,42,43,44,45");
        Lotto matchThree = new Lotto("1,2,3,43,44,45");
        Lotto matchFive = new Lotto("1,2,3,4,5,45");
        List<Lotto> lottos = List.of(matchOne, matchThree, matchFive);

        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);
        Map<Rank, Integer> matchingStats = lottoResults.matchingStats();

        assertThat(matchingStats)
                .containsEntry(Rank.SECOND, 1)
                .containsEntry(Rank.FIFTH, 1);
    }
}
