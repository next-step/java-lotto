package lotto.model;

import org.junit.Test;

import java.util.Arrays;

public class WinningLottoTest {

    @Test
    public void 생성() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5), 7);
    }

}