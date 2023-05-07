package lotto.domain;

import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void toStringTest() {
        Set<LottoNumber> lottoNumbers = Set.of(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).hasToString("[1, 2, 3, 4, 5, 6]");
    }
}
