package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    @DisplayName("당첨 개수 확인")
    void test01() {
        Lotto lotto = LottoFactory.createLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(5);

        assertThat(lotto.contains(lottoNumber)).isTrue();
    }

    @Test
    @DisplayName("당첨 개수 확인")
    void test02() {
        Lotto lotto = LottoFactory.createLotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(7);

        assertThat(lotto.contains(lottoNumber)).isFalse();
    }

}
