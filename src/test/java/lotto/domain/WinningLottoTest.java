package lotto.domain;

import org.junit.Test;

public class WinningLottoTest {

    @Test
    public void 당첨번호_저장() {
        //에러 안나면 정상
        String[] winningNumbers = {"1","2","3","4","5","6"};
        String bonusNumber = "7";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        System.out.println(winningLotto.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스번호_중복확인() {
        String[] winningNumbers = {"1","2","3","4","5","6"};
        String bonusNumber = "5";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        System.out.println(winningLotto.toString());
    }
}
