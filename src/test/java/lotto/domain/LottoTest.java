package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = new Lotto(1,2,3,4,5,6);
    }

    @Test
    public void create() {
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))));
    }

    @Test
    public void insufficientLottoNumbersThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3)));
        });
    }

    @Test
    public void insufficientNumbersThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1,2,3);
        });
    }

    @Test
    public void match_6개_테스트() {
        Lotto winningNumbers = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        Assertions.assertThat(lotto.match(winningNumbers)).isEqualTo(6);
    }

    @Test
    public void match_3개_테스트() {
        Lotto winningNumbers = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9)));

        assertThat(lotto.match(winningNumbers)).isEqualTo(3);
    }
}
