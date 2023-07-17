package lotto.domain;

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
        Lotto lottoContent = LottoGenerator.generateOne(testStrategy);

        /* then */
        assertThat(lottoContent).isEqualTo(new Lotto(testCandidate));
    }

    @Test
    @DisplayName("로또 번호 데이터를 돈 액수만큼 생성한다.")
    void generate() {
        /* given */
        LottoMoney lottoMoney = new LottoMoney(3_000L);

        /* when */
        Lottos lottoContents = LottoGenerator.generateLottos(lottoMoney, testStrategy);

        /* then */
        assertThat(lottoContents.getLottos()).containsExactly(
                new Lotto(testCandidate),
                new Lotto(testCandidate),
                new Lotto(testCandidate)
        );
    }
}
