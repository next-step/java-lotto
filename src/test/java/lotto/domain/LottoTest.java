package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("로또 테스트")
class LottoTest {

//    @DisplayName("45개 이하의 숫자 6개를 가진다.")
//    @Test
//    void checkLottoNumber() {
//        Lotto lotto = new Lotto();
//        List<Integer> lottoNumbers = lotto.getLottoNumbers();
//        for (Integer number : lottoNumbers) {
//            Assertions.assertTrue(number <= 45);
//        }
//    }

    @DisplayName("로또 당첨 개수를 확인한다.")
    @Test
    void countWinning() {
        List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,1,1,1));
        int result = lotto.countWinningNumber(winningLotto);
        Assertions.assertEquals(result, 3);
    }
}
