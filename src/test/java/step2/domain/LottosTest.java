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
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> secondExpectedLottoNumbers = Stream.of(2, 3, 4, 5, 6, 10)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> thridExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 5, 9)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> fourthExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 8, 9)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> fifthExpectedLottoNumbers = Stream.of(1, 2, 3, 7, 8, 9)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Lotto firstLotto = new Lotto(firstExpectedLottoNumbers);
        Lotto secondLotto = new Lotto(secondExpectedLottoNumbers);
        Lotto thirdLotto = new Lotto(thridExpectedLottoNumbers);
        Lotto fourthLotto = new Lotto(fourthExpectedLottoNumbers);
        Lotto fifthLotto = new Lotto(fifthExpectedLottoNumbers);
        Lotto winnerLotto = new Lotto(winnerLottoNumbers);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto, fourthLotto, fifthLotto);
        Lottos wrappedLottos = new Lottos(lottos);

        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(10, winnerLottoNumbers);
        Map<Rank, Long> matchResults = wrappedLottos.getMatchResults(winnerLotto, lottoBonusNumber);

        Rank firstWinner = Rank.valueOf(6, false);
        Rank secondWinner = Rank.valueOf(5, false);
        Rank thirdWinner = Rank.valueOf(5, true);
        Rank fourthWinner = Rank.valueOf(4, false);
        Rank fifthWinner = Rank.valueOf(3, false);

        assertAll(
                () -> assertEquals(matchResults.get(firstWinner), 1),
                () -> assertEquals(matchResults.get(secondWinner), 1),
                () -> assertEquals(matchResults.get(thirdWinner), 1),
                () -> assertEquals(matchResults.get(fourthWinner), 1),
                () -> assertEquals(matchResults.get(fifthWinner), 1));
    }

    @DisplayName("당첨번호와 전부 일치 안하는 경우 테스트")
    @Test
    void getAllNotMatchResultsTest() {

        Set<LottoNumber> firstExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> secondExpectedLottoNumbers = Stream.of(2, 3, 4, 5, 6, 7)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> thridExpectedLottoNumbers = Stream.of(1, 2, 3, 4, 8, 9)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Set<LottoNumber> winnerLottoNumbers = Stream.of(11, 12, 13, 21, 31, 41)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Lotto firstLotto = new Lotto(firstExpectedLottoNumbers);
        Lotto secondLotto = new Lotto(secondExpectedLottoNumbers);
        Lotto thirdLotto = new Lotto(thridExpectedLottoNumbers);
        Lotto winnerLotto = new Lotto(winnerLottoNumbers);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto);
        Lottos wrappedLottos = new Lottos(lottos);

        LottoBonusNumber lottoBonusNumber = new LottoBonusNumber(10, winnerLottoNumbers);
        Map<Rank, Long> matchResults = wrappedLottos.getMatchResults(winnerLotto, lottoBonusNumber);
        assertTrue(matchResults.isEmpty());
    }

}