package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    public void 생성() {
        LottoNumber num1 = LottoNumber.of(1);
        LottoNumber num2 = LottoNumber.of(2);
        LottoNumber num3 = LottoNumber.of(3);
        LottoNumber num4 = LottoNumber.of(4);
        LottoNumber num5 = LottoNumber.of(5);
        LottoNumber num6 = LottoNumber.of(6);
        LottoNumbers numbers = new LottoNumbers(num1, num2, num3, num4, num5, num6);
        assertThat(numbers).isEqualTo(new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));
    }

    @Test
    public void 생성_숫자_부족() {
        assertThatThrownBy(() -> {
            LottoNumbers numbers = new LottoNumbers(LottoNumber.of(1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 숫자_매칭_확인() {
        LottoNumbers numbers1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        LottoNumbers numbers2 = new LottoNumbers(
                LottoNumber.of(7),
                LottoNumber.of(8),
                LottoNumber.of(9),
                LottoNumber.of(10),
                LottoNumber.of(11),
                LottoNumber.of(12)
        );
        MatchCount expectedMatchCount = new MatchCount(0);
        assertThat(numbers1.getMatchCount(numbers2)).isEqualTo(expectedMatchCount);
    }

    @Test
    public void 숫자_매칭_확인2() {
        LottoNumbers numbers1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        LottoNumbers numbers2 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(8),
                LottoNumber.of(9),
                LottoNumber.of(10),
                LottoNumber.of(11),
                LottoNumber.of(12)
        );
        MatchCount expectedMatchCount = new MatchCount(1);
        assertThat(numbers1.getMatchCount(numbers2)).isEqualTo(expectedMatchCount);
    }

    @Test
    public void 숫자_매칭_확인3() {
        LottoNumbers numbers1 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        LottoNumbers numbers2 = new LottoNumbers(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
        MatchCount expectedMatchCount = new MatchCount(6);
        assertThat(numbers1.getMatchCount(numbers2)).isEqualTo(expectedMatchCount);
    }

}
