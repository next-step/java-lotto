package lotto;

import lotto.core.Lotto;
import lotto.core.LottoCommonGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("6개의 숫자가 생성되는지 확인")
    void testIfGenerate6Nums(){
        Lotto lotto = new Lotto(new LottoCommonGenerateStrategy());

        List<Integer> lottoNums = lotto.getLottoNums();
        assertThat(lottoNums).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호가 동일한 갯수 반환 확인 - 6개")
    void testIfGetLottoCorrectCount6(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        Lotto winningLottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));

        int result = lotto.getCorrectCount(winningLottoNumbers);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호가 동일한 갯수 반환 확인 - 5개")
    void testIfGetLottoCorrectCount5(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,33,4,5,6));

        Lotto winningLottoNumbers = new Lotto(Arrays.asList(1,2,3,4,5,6));

        int result = lotto.getCorrectCount(winningLottoNumbers);
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 갯수가 6개가 넘을 경우 Exception 확인")
    void testIfThrowExceptionWithTooBigLottoSize(){
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,5,6,7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto cannot have number quantity bigger than 6");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있는 경우 Exception 확인")
    void testIfThrowExceptionWithDuplicateNumbers(){
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1,2,3,4,6,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("lotto cannot have duplicate numbers");
    }
}
