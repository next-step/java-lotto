package step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class SameLottoCheckerTest {


    @Test
    void hasSameLotto() {

        Lotto given = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        Lotto result = new Lotto(Arrays.asList(
                new LottoNumber(6),
                new LottoNumber(4),
                new LottoNumber(2),
                new LottoNumber(1),
                new LottoNumber(5),
                new LottoNumber(3)
        ));

        assertThat(SameLottoChecker.isSameLotto(given,result)).isTrue();
    }
}