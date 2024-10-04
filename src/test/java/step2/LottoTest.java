package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;

import java.util.Arrays;

/*
- 당첨번호를 입력받는다.
- 당첨번호와 비교하여 일치하는 번호의 개수를 출력한다.
- 손해율을 내려준다.
*/
public class LottoTest {

    @DisplayName("당첨번호와 비교하여 일치하는 번호의 개수를 출력한다.")
    @Test
    void checkLottoNumTest(){
        Lotto lotto = new Lotto();
        lotto.addLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

//        int num = lotto.checkPrizeNum(Arrays.asList(1, 2, 3, 4, 5, 6));

    }
}
