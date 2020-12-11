package lotto;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    private static LottoSimulator lottoSimulator;

    @BeforeAll
    public static void init() {
        lottoSimulator = new LottoSimulator(new SequentialLottoNumberGenerator());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,5", "1,2,3,4,5,6,7", "1,2,3,4,5,99"})
    public void testInvalidLottoNumbers(String csvNumbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(csvNumbers.split(","))
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList());

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoGame(lottoNumbers);
        });
    }

    @Test
    public void testSequentialLottoNumberGenerator() {
        List<Integer> expectedFirst = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expectedSecond = Arrays.asList(7, 8, 9, 10, 11, 12);

        SequentialLottoNumberGenerator generator = new SequentialLottoNumberGenerator();

        assertThat(generator.generate()
                .stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .collect(Collectors.toList())).isEqualTo(expectedFirst);

        assertThat(generator.generate()
                .stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .collect(Collectors.toList())).isEqualTo(expectedSecond);

        assertThat(new SequentialLottoNumberGenerator().generate()
                .stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .collect(Collectors.toList())).isEqualTo(expectedFirst);
    }

    @Test
    public void testMatchedPlace() {
        LottoGame lottoGame = buildLottoGame(1, 2, 3, 4, 5, 6);
        LottoGame matched3 = buildLottoGame(1, 2, 3, 11, 12, 13);

        LottoPlace matchedPlace = lottoGame.getMatchedPlace(matched3);

        assertThat(matchedPlace).isEqualTo(LottoPlace.MATCHED_3);
    }

    @Test
    public void testNotMatchedPlace() {
        LottoGame lottoGame = buildLottoGame(1, 2, 3, 4, 5, 6);
        LottoGame matched0 = buildLottoGame(11, 12, 13, 14, 15, 16);

        LottoPlace matchedPlace = lottoGame.getMatchedPlace(matched0);

        assertThat(matchedPlace).isEqualTo(LottoPlace.MATCHED_NONE);
    }

    @Test
    public void testWinFirstPlaceAndMiss() {
        final int GAMES = 2;
        final int COST = LottoSimulator.LOTTO_GAME_PRICE * GAMES;

        // will buy 1,2,3,4,5,6 and 7,8,9,10,11,12
        List<LottoGame> boughtLottoGames = lottoSimulator.buy(COST);

        assertThat(boughtLottoGames.size()).isEqualTo(GAMES);

        List<LottoNumber> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());

        LottoResult result = lottoSimulator.getWinnerResult(winningNumbers);

        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_6)).isEqualTo(1);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_5)).isEqualTo(0);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_4)).isEqualTo(0);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_3)).isEqualTo(0);
        assertThat(result.getWinnerPlaceCount(LottoPlace.MATCHED_NONE)).isEqualTo(1);

        assertThat(result.getProfitRatio())
                .isCloseTo(LottoPlace.MATCHED_6.getPrize() / COST, Percentage.withPercentage(1));
    }

    private static LottoGame buildLottoGame(Integer... a) {
        List<LottoNumber> lottoNumbers = Arrays.asList(a).stream()
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());

        return new LottoGame(lottoNumbers);
    }

}
