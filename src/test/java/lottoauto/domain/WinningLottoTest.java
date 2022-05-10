package lottoauto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {
    @Test
    void WinnigLotto_생성_정상() {
        assertThat(WinningLotto.of(Lotto.from("1, 2, 3, 4, 5, 6"), LottoNumber.from(7))).isNotNull();
    }

    @Test
    void WinnigLotto_생성_보너스번호_중복_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            WinningLotto.of(Lotto.from("1, 2, 3, 4, 5, 6"), LottoNumber.from(6));
        }).withMessageContaining("중복");
    }

    @ParameterizedTest(name = "등수_확인")
    @MethodSource("provideTestData")
    void 등수_확인(String[] winningLotto, String[] lotto, Rating ratingResult) {
        Rating rating = WinningLotto.from(Lotto.from(winningLotto)).findRating(Lotto.from(lotto));
        System.out.println(rating);
        assertThat(rating).isEqualTo(ratingResult);
    }
    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "6"}, Rating.FIRST),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "5", "7"}, Rating.THIRD),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "4", "7", "8"}, Rating.FOURTH),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"1", "2", "3", "7", "8", "9"}, Rating.FIFTH)
        );
    }

    @ParameterizedTest(name = "등수_확인_보너스_번호_추가")
    @MethodSource("provideTestDataBonus")
    void 등수_확인_보너스_번호_추가(String[] winningLotto, int bonusNumber, String[] lotto, Rating ratingResult) {
        Rating rating = WinningLotto.of(Lotto.from(winningLotto),LottoNumber.from(bonusNumber))
                .findRating(Lotto.from(lotto));
        System.out.println(rating);
        assertThat(rating).isEqualTo(ratingResult);
    }
    private static Stream<Arguments> provideTestDataBonus() {
        return Stream.of(
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, 7, new String[]{"1", "2", "3", "4", "5", "6"}, Rating.FIRST),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, 7, new String[]{"1", "2", "3", "4", "5", "7"}, Rating.SECOND),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, 7, new String[]{"1", "2", "3", "4", "5", "8"}, Rating.THIRD),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, 7, new String[]{"1", "2", "3", "4", "7", "8"}, Rating.FOURTH),
                Arguments.of(new String[]{"1", "2", "3", "4", "5", "6"}, 7, new String[]{"1", "2", "3", "7", "8", "9"}, Rating.FIFTH)
        );
    }

}