package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
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
        }).withMessage(Lotto.SIZE_ERROR_MESSAGE);
    }

    @Test
    public void insufficientNumbersThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 2, 3);
        }).withMessage(Lotto.SIZE_ERROR_MESSAGE);
    }

    @Test
    public void duplicateNumbersThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 2, 3, 1, 2, 3);
        }).withMessage(Lotto.DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    public void duplicateLottoNumbersThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(1)));
        }).withMessage(Lotto.DUPLICATE_ERROR_MESSAGE);
    }

    @Test
    public void match_6개_테스트() {
        Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.match(winningNumbers)).isEqualTo(6);
    }

    @Test
    public void match_3개_테스트() {
        Lotto winningNumbers = new Lotto(1, 2, 3, 7, 8, 9);
        assertThat(lotto.match(winningNumbers)).isEqualTo(3);
    }
}
