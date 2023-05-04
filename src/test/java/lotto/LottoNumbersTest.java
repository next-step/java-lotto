package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    @DisplayName("전체로또숫자생성확인")
    void 전체로또숫자생성확인() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 1, 5, 6, 40, 46));
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1~45 이외의 숫자가 포함되어 있습니다.");
    }

}
