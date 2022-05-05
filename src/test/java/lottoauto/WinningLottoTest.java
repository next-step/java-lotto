package lottoauto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @ParameterizedTest
    @MethodSource("provideTestData")
    void WinnigLotto_등수_확인(String[] winningLotto, String[] lotto, Rating ratingResult) {
        Rating rating = WinningLotto.from(winningLotto).matchingCount(Lotto.from(lotto));
        System.out.println(rating.toString());
        assertThat(rating).isEqualTo(ratingResult);
    }

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "6"}, Rating.FIRST),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "7"}, Rating.SECOND),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "7", "8"}, Rating.THIRD),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "7", "8", "9"}, Rating.FOURTH),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"7", "8", "9", "10", "11", "12"}, Rating.LOSING)
        );
    }
}