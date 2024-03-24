package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    private final String ERROR_MESSAGE = "로또 번호는 총 6개이고 각 번호는 1 ~ 45 사이의 값만 가능합니다." ;

    @Test
    @DisplayName("로또 번호 생성 테스트")
    void testLotto_ValidNumbers_ShouldConstructCorrectLotto() {
        List<Integer> inputNum = new ArrayList<>(Arrays.asList(21,22,39,4,1,16));
        List<Integer> lottoNumbers = new Lotto(inputNum).getLotto();

        for (int i = 0; i < 6; i++) {
            assertThat(lottoNumbers.get(i)).isEqualTo(inputNum.get(i));
        }
    }

    @Test
    @DisplayName("범위를 넘는 번호 입력시 에러 발생 테스트")
    void inputLottoNum_rangeOver() {

        assertThatThrownBy(() -> new Lotto(new ArrayList<>(Arrays.asList(99,27,31,9,46))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @Test
    @DisplayName("로또 번호가 6개를 초과할 경우, 에러 발생 테스트")
    void inputLottoNum_countOver() {

        assertThatThrownBy(() -> new Lotto(new ArrayList<>(Arrays.asList(9,12,33,44,6,1,11,40))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
