package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 번호가 몇개 맞는지 확인")
    void 로또_당첨_번호수_확인() {
        List<Integer> winningList = Arrays.asList(2,2,2,1,1,1);
        Lotto lotto = new Lotto(new TestNumberGeneration());

        int result = lotto.countMatchNumber(winningList);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 번호 print 형식 확인")
    void 로또_번호_리턴() {
        Lotto lotto = new Lotto(new TestNumberGeneration());
        String text = "[1, 1, 1, 1, 1, 1]";
        Assertions.assertThat(lotto.findNumbersForPrint()).isEqualTo(text);
    }
}
