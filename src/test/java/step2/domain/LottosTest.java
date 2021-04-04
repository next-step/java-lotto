package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @DisplayName("당첨번호와 일치하는 갯수 테스트")
    @Test
    void getMatchResultsTest() {

        Set<LottoNumber> firstExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> secondExpectedLottoNumbers = Stream.of(2, 3, 4, 5, 6, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> thridExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 8, 9)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> fourthExpectedLottoNumbers = Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Lotto firstLotto = new Lotto(firstExpectedLottoNumbers);
        Lotto secondLotto = new Lotto(secondExpectedLottoNumbers);
        Lotto thirdLotto = new Lotto(thridExpectedLottoNumbers);
        Lotto fourthLotto = new Lotto(fourthExpectedLottoNumbers);
        Lotto winnerLotto = new Lotto(winnerLottoNumbers);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto, fourthLotto);
        Lottos wrappedLottos = new Lottos(lottos);

        Map<Integer, Long> matchResults = wrappedLottos.getMatchResults(winnerLotto);
        assertAll(
                () -> assertEquals(matchResults.get(6), 1),
                () -> assertEquals(matchResults.get(5), 1),
                () -> assertEquals(matchResults.get(4), 1),
                () -> assertEquals(matchResults.get(3), 1));
    }

    @DisplayName("당첨번호와 전부 일치 안하는 경우 테스트")
    @Test
    void getAllNotMatchResultsTest() {

        Set<LottoNumber> firstExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> secondExpectedLottoNumbers = Stream.of(2, 3, 4, 5, 6, 7)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> thridExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 8, 9)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Set<LottoNumber> winnerLottoNumbers = Stream.of(11, 12, 13, 21, 31, 41)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        Lotto firstLotto = new Lotto(firstExpectedLottoNumbers);
        Lotto secondLotto = new Lotto(secondExpectedLottoNumbers);
        Lotto thirdLotto = new Lotto(thridExpectedLottoNumbers);
        Lotto winnerLotto = new Lotto(winnerLottoNumbers);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto);
        Lottos wrappedLottos = new Lottos(lottos);

        Map<Integer, Long> matchResults = wrappedLottos.getMatchResults(winnerLotto);
        assertTrue(matchResults.isEmpty());
    }

}