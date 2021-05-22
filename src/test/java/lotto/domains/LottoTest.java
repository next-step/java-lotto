package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 당첨번호_1개_테스트() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1,21,31,10,11,12)));
        assertThat(lotto.checkNumber(new LottoNumbers(winningNumber))).isEqualTo(1);
    }
    @Test
    void 당첨번호_2개_테스트() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1,2,31,10,11,12)));
        assertThat(lotto.checkNumber(new LottoNumbers(winningNumber))).isEqualTo(2);
    }

    @Test
    void 로또번호_가져오기_테스트() {
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto.lottoNumbers()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
