package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @DisplayName("로또 생성시 로또 번호 리스트의 길이가 6이 아니면 에러.")
    @Test
    void validateLottoListTest() {
        Integer[] lottoNumbers = {1, 2, 3, 4, 5, 6, 7};

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Lotto(Arrays.asList(lottoNumbers));
                });
    }

    @DisplayName("로또에서 로또 번호 리스트를 가져올 수 있다.")
    @Test
    void getLottoNumbersTest() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> lottoNumbers = lottoMachine.makeLottoNumbers();

        assertThat(new Lotto(lottoNumbers)
                .getLottoNumbers()
                .size()).isEqualTo(Lotto.CORRECT_LOTTO_NUMBERS_SIZE);
    }
}
