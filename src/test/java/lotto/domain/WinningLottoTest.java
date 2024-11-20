package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class WinningLottoTest {

    @Test
    void 당첨번호_생성() {
        LottoNumbers winningLottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        String bonusNumber = "7";

        assertThatNoException().isThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber));
    }

    @Test
    void 당첨번호를_보너스번호로_사용할_수_없다() {
        LottoNumbers winningLottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        String bonusNumber = "1";

        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(winningLottoNumbers, bonusNumber))
                .withMessage("보너스 번호는 당첨번호에 포함될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("gamesAndEarningRate")
    void 전체_게임에_대한_수익률을_구할_수_있다(Games games, double expected) {
        LottoNumbers winner = new LottoNumbers("1,2,3,4,5,6");
        WinningLotto lottoResult = new WinningLotto(winner, "7");

        assertThat(lottoResult.calculateEarningRate(games)).isEqualTo(expected);
    }

    private static Stream<Arguments> gamesAndEarningRate() {
        double twice = 2.00;
        double breakEven = 1.00;
        double twoThird = 0.67;
        double half = 0.50;
        double oneThird = 0.33;

        return Stream.of(
                Arguments.arguments(new Games(getFifthAndNoneGame(2, 3)), twice),
                Arguments.arguments(new Games(getFifthAndNoneGame(1, 4)), breakEven),
                Arguments.arguments(new Games(getFifthAndNoneGame(2, 13)), twoThird),
                Arguments.arguments(new Games(getFifthAndNoneGame(1, 9)), half),
                Arguments.arguments(new Games(getFifthAndNoneGame(1, 14)), oneThird)
        );
    }

    private static List<LottoNumbers> getFifthAndNoneGame(int fifthCount, int noneCount) {
        List<LottoNumbers> fourthGames = IntStream.range(0, fifthCount)
                .mapToObj(i -> new LottoNumbers("1,2,3,7,8,9"))
                .collect(Collectors.toList());
        List<LottoNumbers> noneGames = IntStream.range(0, noneCount)
                .mapToObj(i -> new LottoNumbers("1,2,7,8,9,10"))
                .collect(Collectors.toList());
        fourthGames.addAll(noneGames);

        return fourthGames;
    }
}