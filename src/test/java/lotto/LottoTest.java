package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.lottonumber.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("Lotto 객체를 생성한다")
    void shouldCreateSameObject() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("주어진 개수만큼 로또 번호가 일치하는지 확인한다")
    void shouldSetMatchedLottoNumbersCount() {
        LottoNumbers input = LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.from(input);
        LottoNumbers winningNumbers = LottoNumbers.from(Arrays.asList(1, 2, 3, 7, 8, 9));

        boolean isMatchedThreeNumbers = lotto.match(winningNumbers, count -> count == 3);
        assertThat(isMatchedThreeNumbers).isTrue();
    }

    @Test
    void name() {
        String input = "1, 2, 3, 4, 5, 6";
        String input2 = "1,2,3,4,5,6";
        String[] split = input.split(",\\s|,");
        for (String s : split) {
            System.out.println("s = " + s + "!");
        }
    }
}
