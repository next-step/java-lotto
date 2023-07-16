package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    static List<Integer> testCandidate = List.of(1, 2, 3, 4, 5, 6);
    static CandidateStrategy testStrategy = () -> testCandidate;

    @Test
    @DisplayName("로또를 하나 생성한다.")
    void generateOne() {
        /* given */


        /* when */
        Lotto lotto = LottoGenerator.generateOne(testStrategy);

        /* then */
        assertThat(lotto).isEqualTo(new Lotto(testCandidate));
    }

    @Test
    @DisplayName("로또를 돈 액수만큼 생성한다.")
    void generate() {
        /* given */
        long money = 3_000L;

        /* when */
        List<Lotto> lottos = LottoGenerator.generateLottos(money, testStrategy);

        /* then */
        assertThat(lottos).containsExactly(
                new Lotto(testCandidate),
                new Lotto(testCandidate),
                new Lotto(testCandidate)
        );
    }
}
