package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @DisplayName("로또 번호가 당첨 번호와 일치하는 갯수를 반환하는 테스트")
    @Test
    void countCollectLottoNumber_일치하는_로또_번호_갯수() {
        Lotto lotto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        LottoResult lottoResult = new LottoResult();
        lotto.compareWinLottoNumber(new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8))), lottoResult);
        assertThat(lottoResult.isFirst(1)).isTrue();
    }

    @DisplayName("우승 로또 객체와 유저 로또 객체가 같은지 테스트")
    @Test
    void isEqualUserLottoAndWinLotto() {
        Lotto lotto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        Lotto winlotto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        //assertThat(lotto.compareWinLottoNumber(winlotto, new LottoResult())).isEqualTo(1);
    }
}
