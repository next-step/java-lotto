package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또번호는 6개의 숫자로 구성된다.")
    @Test
    void 로또번호_6개() {
        List<LottoNumber> lottoNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3));
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨번호와 일치하는 로또 개수")
    @Test
    void matchedCount_당첨번호() {
        Lotto lotto = createLotto(new int[]{1, 4, 10, 15, 20, 25});
        Lotto winningLotto = createLotto(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(lotto.matchedCount(winningLotto)).isEqualTo(2);
    }

    private static Lotto createLotto(int[] ints) {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(ints[0]),
                new LottoNumber(ints[1]),
                new LottoNumber(ints[2]),
                new LottoNumber(ints[3]),
                new LottoNumber(ints[4]),
                new LottoNumber(ints[5]));

        return new Lotto(lottoNumbers);
    }
}
