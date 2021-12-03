package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @DisplayName("Lottos, 당첨번호, bonusNumber가 주어졌을 때 기대한 Rank의 Count가 1이 반환되는지 검증")
    @ParameterizedTest
    @MethodSource("ResultParameter")
    void makeResultTest(Lottos lottos, WinningLotto winningLotto, Rank expected) {
        Map<Rank, Integer> results = winningLotto.makeResult(lottos)
                                                 .getRanks();
        assertThat(results.get(expected)).isEqualTo(1);
    }

    private static Stream<Arguments> ResultParameter() {
        List<LottoNumber> pickedLottoNumbers = Arrays.asList(new LottoNumber(1),
                                                             new LottoNumber(2),
                                                             new LottoNumber(3),
                                                             new LottoNumber(4),
                                                             new LottoNumber(5),
                                                             new LottoNumber(6));
        LottoNumber bonusLottoNumber = new LottoNumber(7);

        return Stream.of(Arguments.of(new Lottos(Arrays.asList(new Lotto(pickedLottoNumbers))),
                                      new WinningLotto(new Lotto(Arrays.asList(new LottoNumber(1),
                                                                               new LottoNumber(2),
                                                                               new LottoNumber(3),
                                                                               new LottoNumber(4),
                                                                               new LottoNumber(5),
                                                                               new LottoNumber(6))), bonusLottoNumber),
                                      Rank.FIRST),
                         Arguments.of(new Lottos(Arrays.asList(new Lotto(Arrays.asList(new LottoNumber(1),
                                                                                       new LottoNumber(2),
                                                                                       new LottoNumber(3),
                                                                                       new LottoNumber(4),
                                                                                       new LottoNumber(5),
                                                                                       new LottoNumber(7))))),
                                      new WinningLotto(new Lotto(Arrays.asList(new LottoNumber(1),
                                                                               new LottoNumber(2),
                                                                               new LottoNumber(3),
                                                                               new LottoNumber(4),
                                                                               new LottoNumber(5),
                                                                               new LottoNumber(6))), bonusLottoNumber),
                                      Rank.SECOND),
                         Arguments.of(new Lottos(Arrays.asList(new Lotto(pickedLottoNumbers))),
                                      new WinningLotto(new Lotto(Arrays.asList(new LottoNumber(1),
                                                                               new LottoNumber(2),
                                                                               new LottoNumber(3),
                                                                               new LottoNumber(4),
                                                                               new LottoNumber(5),
                                                                               new LottoNumber(8))), bonusLottoNumber),
                                      Rank.THIRD),
                         Arguments.of(new Lottos(Arrays.asList(new Lotto(pickedLottoNumbers))),
                                      new WinningLotto(new Lotto(Arrays.asList(new LottoNumber(1),
                                                                               new LottoNumber(2),
                                                                               new LottoNumber(3),
                                                                               new LottoNumber(4),
                                                                               new LottoNumber(9),
                                                                               new LottoNumber(10))), bonusLottoNumber),
                                      Rank.FOURTH),
                         Arguments.of(new Lottos(Arrays.asList(new Lotto(pickedLottoNumbers))),
                                      new WinningLotto(new Lotto(Arrays.asList(new LottoNumber(1),
                                                                               new LottoNumber(2),
                                                                               new LottoNumber(3),
                                                                               new LottoNumber(8),
                                                                               new LottoNumber(9),
                                                                               new LottoNumber(10))), bonusLottoNumber),
                                      Rank.FIFTH),
                         Arguments.of(new Lottos(Arrays.asList(new Lotto(pickedLottoNumbers))),
                                      new WinningLotto(new Lotto(Arrays.asList(new LottoNumber(36),
                                                                               new LottoNumber(22),
                                                                               new LottoNumber(15),
                                                                               new LottoNumber(17),
                                                                               new LottoNumber(26),
                                                                               new LottoNumber(44))), bonusLottoNumber),
                                      Rank.MISS));
    }
}
