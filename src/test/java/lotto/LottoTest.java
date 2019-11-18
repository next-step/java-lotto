package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private List<LottoNo> numbers;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3),
                new LottoNo(4), new LottoNo(5), new LottoNo(6));
        lotto = new Lotto(numbers);
    }

    @Test
    void lottoTest() {
        assertThat(numbers).hasSize(6);
    }

    @Test
    void sortTest() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getLottoNumber()).containsExactly(new LottoNo(1), new LottoNo(2),
                new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6));
    }

    @Test
    void containsLottoWinNumber() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.isContainsWinNumber(1)).isTrue();
        assertThat(lotto.isContainsWinNumber(7)).isFalse();
    }

    @Test
    void checkValueWhenHitWinNumber() {
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.isContainsWinNumber(1)).isTrue();
        assertThat(lotto.isContainsWinNumber(6)).isTrue();
        assertThat(lotto.isContainsWinNumber(7)).isFalse();
    }

    @Test
    void validateWithNullTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto lotto = new Lotto(null);
            assertThat(lotto.getLottoNumber()).hasSize(6);
        });
    }
}