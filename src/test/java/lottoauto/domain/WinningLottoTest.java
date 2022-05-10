package lottoauto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 6:FIRST",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 5, 7:THIRD",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 4, 7, 8:FOURTH",
            "1, 2, 3, 4, 5, 6:1, 2, 3, 7, 8, 9:FIFTH"
    }, delimiter = ':')
    void 등수_확인(String winningLotto, String lotto, Rating ratingResult) {
        Rating rating = WinningLotto.from(Lotto.from(winningLotto)).findRating(Lotto.from(lotto));
        System.out.println(rating);
        assertThat(rating).isEqualTo(ratingResult);
    }

    @ParameterizedTest(name = "등수_확인_보너스_번호_추가")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:7:1, 2, 3, 4, 5, 6:FIRST",
            "1, 2, 3, 4, 5, 6:7:1, 2, 3, 4, 5, 7:SECOND",
            "1, 2, 3, 4, 5, 6:7:1, 2, 3, 4, 5, 8:THIRD",
            "1, 2, 3, 4, 5, 6:7:1, 2, 3, 4, 7, 8:FOURTH",
            "1, 2, 3, 4, 5, 6:7:1, 2, 3, 7, 8, 9:FIFTH"
    }, delimiter = ':')
    void 등수_확인_보너스_번호_추가(String winningLotto, int bonusNumber, String lotto, Rating ratingResult) {
        Rating rating = WinningLotto.of(
                            Lotto.from(winningLotto),
                            LottoNumber.from(bonusNumber)
                        ).findRating(Lotto.from(lotto));
        System.out.println(rating);
        assertThat(rating).isEqualTo(ratingResult);
    }
}