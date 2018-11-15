package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호_갯수_맞지않으면_Exception() {
        new Lotto(lottoNumbers(1, 2, 3, 4, 5));
    }

    @Test
    public void 로또간_번호를_비교한다() {
        Lotto lotto1 = new Lotto(lottoNumbers(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(lottoNumbers(1,2,3,4,5,7));

        assertThat(lotto1.match(lotto2)).isEqualTo(5);
    }

    @Test
    public void 로또_번호에_포함되는지_확인한다() {
        Lotto lotto = new Lotto(lottoNumbers(1,2,3,4,5,6));

        assertThat(lotto.contains(new LottoNumber(1))).isTrue();
    }

    private List<LottoNumber> lottoNumbers(Integer... args) {
        return Arrays.stream(args)
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
