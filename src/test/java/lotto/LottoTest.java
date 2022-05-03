package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {
    @Test
    void LottoNumber_로또가_생성된다() {
        assertThat(new Lotto(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )));
    }

    @Test
    void LottoNumber_로또_자동_생성시_6글자가_아닌_경우() {
        assertThatThrownBy(() -> new Lotto(new int[]{1,2,3,4,5,6,7})).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void LottoNumber_로또_번호가_중복인_경우() {
        assertThatThrownBy(() -> new Lotto(new int[]{1,1,3,4,5,6})).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6, FIRST",
            "1,2,3,4,5,45, SECOND",
            "1,2,3,4,44,45, THIRD",
            "1,2,3,43,44,45, FOURTH",
            "1,2,42,43,44,45, MISS",
            "1,41,42,43,44,45, MISS",
            "40,41,42,43,44,45, MISS"
    })
    void getRank_로또_등수_판별(int num1, int num2, int num3, int num4, int num5, int num6, String rank) {
        Lotto lotto = new Lotto(new int[]{num1, num2, num3, num4, num5, num6});
        assertThat(lotto.getRank(new Lotto(new int[]{1, 2, 3, 4, 5, 6}))).isEqualTo(Rank.valueOf(rank));
    }
}
