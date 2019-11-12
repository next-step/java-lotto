package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBox;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBoxTest {
    @Test
    @DisplayName("매번 다른 번호가 생성되는지 확인한다.")
    void isRandomNumbers() {
        Lotto firstLotto = LottoBox.generateLotto();
        Lotto second = LottoBox.generateLotto();
        assertThat(firstLotto).isNotEqualTo(second);
    }

    @Test
    @DisplayName("입력받은 로또 번호를 넣었을때 6개의 로또 번호가 생성 되는지 확인 한다.")
    void parseNumberString() {
        String numberString = "1, 2, 3, 4, 5, 6";
        String[] expectedNumbers = numberString.split(", ");
        Lotto lotto = LottoBox.parseNumberString(numberString);

        for (String number : expectedNumbers) {
            assertThat(lotto.contains(new LottoNumber(number))).isTrue();
        }
    }
}
