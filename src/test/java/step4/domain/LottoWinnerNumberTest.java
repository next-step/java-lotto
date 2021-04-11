package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.exception.IllegalLottoBonusNumberException;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinnerNumberTest {

    @DisplayName("로또 보너스 번호 - 정상 생성")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1,2,3,4,5,6,9",
                    "10,11,12,13,15,16:17",
                    "1,2,3,4,5,45:6",
                    "1,2,3,4,11,22:33",
                    "1,2,3,11,22,33:44"},
            delimiter = ',')
    void lottoBonusNumberTest(String expectedLottoNumbers, int bonusNumber) {
        Assertions.assertDoesNotThrow(() -> new LottoWinnerNumber(bonusNumber, expectedLottoNumbers));
    }

    @DisplayName("로또 보너스 번호 - 로또번호와 중복될 경우")
    @ParameterizedTest
    @CsvSource(
            value = {
                    "1,2,3,4,5,6:6",
                    "10,11,12,13,15,16:16",
                    "1,2,3,4,5,45:5",
                    "1,2,3,4,11,22:4",
                    "1,2,3,11,22,33:3"},
            delimiter = ',')
    void lottoBonusNumberDuplicatedTest(String expectedLottoNumbers, int bonusNumber) {

        Assertions.assertThrows(
                IllegalLottoBonusNumberException.class,
                () -> new LottoWinnerNumber(bonusNumber, expectedLottoNumbers));
    }

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

        String winnerLottoNumbers = "1,2,3,4,5,6";

        Lotto firstLotto = new Lotto(firstExpectedLottoNumbers);
        Lotto secondLotto = new Lotto(secondExpectedLottoNumbers);
        Lotto thirdLotto = new Lotto(thridExpectedLottoNumbers);
        Lotto fourthLotto = new Lotto(fourthExpectedLottoNumbers);
        Lotto fifthLotto = new Lotto(fifthExpectedLottoNumbers);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto, fourthLotto, fifthLotto);

        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(10, winnerLottoNumbers);
        Map<Rank, Long> matchResults = lottoWinnerNumber.getMatchResults(lottos);

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

        String winnerLottoNumbers = "11,12,13,14,15,16";

        Lotto firstLotto = new Lotto(firstExpectedLottoNumbers);
        Lotto secondLotto = new Lotto(secondExpectedLottoNumbers);
        Lotto thirdLotto = new Lotto(thridExpectedLottoNumbers);

        List<Lotto> lottos = Arrays.asList(firstLotto, secondLotto, thirdLotto);

        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(10, winnerLottoNumbers);
        Map<Rank, Long> matchResults = lottoWinnerNumber.getMatchResults(lottos);
        assertTrue(matchResults.isEmpty());
    }
}