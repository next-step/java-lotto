package lotto.service;

import lotto.domain.Games;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoServiceTest {

    private static final LottoService lottoService = new LottoService();

    @ParameterizedTest
    @CsvSource({"1000, 1", "5000, 5", "10000, 10"})
    void 로또_구매(int money, int expected) {
        Games games = lottoService.purchaseLotto(money);

        assertThat(games.count()).isEqualTo(expected);
    }

    @Test
    void 당첨_번호() {
        String input = "1,2,3,4,5,6";
        LottoNumbers winner = lottoService.findWinner(input);

        SoftAssertions.assertSoftly(softly -> softAssertContainsEveryLottoNumber(softly, input, winner));
    }

    private static void softAssertContainsEveryLottoNumber(SoftAssertions softly, String input, LottoNumbers winner) {
        String[] split = input.split(",");
        for (String number : split) {
            softly.assertThat(winner.contains(LottoNumber.valueOf(number))).isTrue();
        }
    }

    @Test
    void 당첨번호를_보너스번호로_사용할_수_없다() {
        String input = "1,2,3,4,5,6";
        LottoNumbers winner = new LottoNumbers(input);

        SoftAssertions.assertSoftly(softly -> softAssertThrowIllegalArgumentException(softly, input, winner));
    }

    private static void softAssertThrowIllegalArgumentException(SoftAssertions softly, String input, LottoNumbers winner) {
        String[] split = input.split(",");
        for (String number : split) {
            softly.assertThatThrownBy(() -> lottoService.getBonusLottoNumber(number, winner))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("보너스 번호는 당첨번호에 포함될 수 없습니다.");
        }
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    void 결과_확인(LottoNumbers game, double expected) {
        LottoNumbers winner = new LottoNumbers("1,2,3,4,5,6");
        LottoNumber bonuslottoNumber = LottoNumber.bonusLottoNumberOf("7", winner);
        Games games = new Games(List.of(game));

        LottoResult lottoResult = lottoService.checkResult(winner, bonuslottoNumber, games);

        assertThat(lottoResult.calculateEarningRate()).isEqualTo(expected);
    }

    public static Stream<Arguments> lottoNumbersAndRank() {
        return Stream.of(
                arguments(new LottoNumbers("1,2,3,4,5,6"), 2000000.0),
                arguments(new LottoNumbers("1,2,3,4,5,7"), 30000.0),
                arguments(new LottoNumbers("1,2,3,4,5,8"), 1500.0),
                arguments(new LottoNumbers("1,2,3,4,7,8"), 50.0),
                arguments(new LottoNumbers("1,2,3,7,8,9"), 5.0),
                arguments(new LottoNumbers("1,2,7,8,9,10"), 0.0)
        );
    }
}