package lotto.domain;

import org.junit.Test;

public class WinningLottoTest {

    //TODO: 당첨번호 저장, 보너스번호 저장
    //toLottoNumber ,, String[] -> List<LottoNumber>
    //toInt -> 보너스번호 저장

    @Test
    public void 당첨번호_저장() {
        //에러 안나면 정상
        String[] winningNumbers = {"1","2","3","4","5","6"};
        String bonusNumber = "7";
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        System.out.println(winningLotto.toString());
    }
}
