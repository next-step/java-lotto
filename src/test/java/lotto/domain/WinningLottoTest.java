package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    public void 당첨번호생성() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningLotto.size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지않은_당첨번호() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(1, 1, 50)));

    }
}