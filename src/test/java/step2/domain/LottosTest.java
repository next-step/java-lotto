package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class LottosTest {

    @DisplayName("로또 매치 결과 테스트")
    @Test
    void lottosGetMatchResultsTest() {

        List<Integer> firstNumbers =
                Stream.of(1, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<Integer> secondNumbers =
                Stream.of(10, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<Integer> thirdNumber =
                Stream.of(11, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<Integer> winnerNumbers =
                Stream.of(11, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<LottoNumberGenerator> lottoNumberGenerators = Arrays.asList(
                new LottoFixedLottoNumberGenerator(firstNumbers),
                new LottoFixedLottoNumberGenerator(secondNumbers),
                new LottoFixedLottoNumberGenerator(thirdNumber));

        Lotto lotto = new Lotto(new LottoFixedLottoNumberGenerator(winnerNumbers));
        Lottos lottos = new Lottos(lottoNumberGenerators);
        Map<Integer, Long> matchResults = lottos.getMatchResults(lotto);

        assertAll(
                () -> assertEquals(matchResults.get(6), 1),
                () -> assertEquals(matchResults.get(5), 2),
                () -> assertEquals(matchResults.get(4), null)
        );
    }
    
    @DisplayName("로또 매치 결과 테스트 - 모두 일치 안함")
    @Test
    void lottosGetMatchResultsAllNoMatchTest() {

        List<Integer> firstNumbers =
                Stream.of(1, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<Integer> secondNumbers =
                Stream.of(10, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<Integer> thirdNumber =
                Stream.of(11, 12, 13, 14, 15, 16)
                        .collect(Collectors.toList());

        List<Integer> winnerNumbers =
                Stream.of(21, 22, 23, 24, 25, 26)
                        .collect(Collectors.toList());

        List<LottoNumberGenerator> lottoNumberGenerators = Arrays.asList(
                new LottoFixedLottoNumberGenerator(firstNumbers),
                new LottoFixedLottoNumberGenerator(secondNumbers),
                new LottoFixedLottoNumberGenerator(thirdNumber));

        Lotto lotto = new Lotto(new LottoFixedLottoNumberGenerator(winnerNumbers));
        Lottos lottos = new Lottos(lottoNumberGenerators);
        Map<Integer, Long> matchResults = lottos.getMatchResults(lotto);

        assertAll(
                () -> assertEquals(matchResults.get(6), null),
                () -> assertEquals(matchResults.get(5), null),
                () -> assertEquals(matchResults.get(4), null)
        );
    }

}