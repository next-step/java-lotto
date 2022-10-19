package lotto;

import lotto.core.Lotto;
import lotto.core.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("6개의 숫자가 생성되는지 확인")
    void testIfGenerate6Nums(){
        Lotto lotto = new Lotto();

        List<Integer> lottoNums = lotto.getLottoNums();
        assertThat(lottoNums).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 동일한 갯수 반환 확인 - 6개")
    void testIfGetLottoCorrectCount6(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1,2,3,4,5,6));

        int result = lotto.getCorrectCount(winningNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호가 동일한 갯수 반환 확인 - 5개")
    void testIfGetLottoCorrectCount5(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,33,4,5,6));

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1,2,3,4,5,6));

        int result = lotto.getCorrectCount(winningNumbers);
        assertThat(result).isEqualTo(5);
    }
}
