package domain;

import lotto.domain.CandidateStrategy;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    static List<Integer> testCandidate = List.of(1, 2, 3, 4, 5, 6);
    static CandidateStrategy testStrategy = () -> testCandidate;

    @Test
    @DisplayName("로또 번호 데이터를 하나 생성한다.")
    void generateOne() {
        /* given */


        /* when */
        List<Integer> lottoContent = LottoGenerator.generateOne(testStrategy);

        /* then */
        assertThat(lottoContent).isEqualTo(testCandidate);
    }

    @Test
    @DisplayName("로또 번호 데이터를 돈 액수만큼 생성한다.")
    void generate() {
        /* given */
        long money = 3_000L;

        /* when */
        List<List<Integer>> lottoContents = LottoGenerator.generateLottoContents(money, testStrategy);

        /* then */
        assertThat(lottoContents).containsExactly(testCandidate, testCandidate, testCandidate);
    }
}
