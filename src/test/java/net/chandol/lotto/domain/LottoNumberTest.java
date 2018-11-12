package net.chandol.lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void null은허용하지않음() {
        LottoNumber.direct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자는6개가되어야함() {
        LottoNumber.direct(asList(1, 2, 3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자는중복을허용하지않음() {
        LottoNumber.direct(asList(1, 1, 1, 1, 1, 1));
    }

    @Test
    public void 번호직접입력() {
        LottoNumber lottoNumber = LottoNumber.direct(1, 2, 3, 4, 5, 6);
        assertThat(lottoNumber.getLottoNumbers())
                .hasSize(6)
                .contains(1, 2, 3, 4, 5, 6);
    }

    // 테스트할 수 없는 영역..
    // 테스트할 수 있는 부분까지만 수행한다.
    @Test
    public void 번호자동입력() {
        LottoNumber lottoNumber = LottoNumber.auto();
        assertThat(lottoNumber.getLottoNumbers())
                .hasSize(6);
    }

    @Test
    public void 다른로또번호와매칭결과확인() {
        LottoNumber num1 = LottoNumber.direct(1, 2, 3, 4, 5, 6);
        LottoNumber num2 = LottoNumber.direct(5, 6, 7, 8, 9, 10);
        List<Integer> matchNumbers = num1.getMatchNumbers(num2);

        Assertions.assertThat(matchNumbers).containsExactly(5, 6);
    }
    @Test
    public void 다른로또번호와매칭사이즈확인() {
        LottoNumber num1 = LottoNumber.direct(1, 2, 3, 4, 5, 6);
        LottoNumber num2 = LottoNumber.direct(5, 6, 7, 8, 9, 10);
        Integer matchNumbers = num1.getMatchSize(num2);

        Assertions.assertThat(matchNumbers).isEqualTo(2);
    }

}
