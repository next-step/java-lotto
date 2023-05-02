package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("lotto 번호 45번까지 잘 만들어지는 지 확인")
    public void allNumberCheck() {
        Lotto lotto = new Lotto();
        List<Integer> result = lotto.totalNumber();

        assertEquals(result.size(), 45);
        for(int number : result) {
            assertThat(number).isLessThanOrEqualTo(45);
        }
    }

    @Test
    @DisplayName("lotto 객체 생성 확인")
    public void numberCheck() {
        Lotto lotto = new Lotto();
        Lotto lotto1 = new Lotto();
        Lotto lotto2 = new Lotto();

        assertAll("lotto size == 6",
                () -> assertEquals(lotto.checkedNumber().size(), 6),
                () -> assertEquals(lotto1.checkedNumber().size(), 6),
                () -> assertEquals(lotto2.checkedNumber().size(), 6)
        );

        assertAll("lottoNumber sort",
                () -> assertThat(lotto.checkedNumber().get(0)).isLessThan(lotto.checkedNumber().get(1)),
                () -> assertThat(lotto.checkedNumber().get(1)).isLessThan(lotto.checkedNumber().get(2)),
                () -> assertThat(lotto.checkedNumber().get(2)).isLessThan(lotto.checkedNumber().get(3)),
                () -> assertThat(lotto.checkedNumber().get(3)).isLessThan(lotto.checkedNumber().get(4)),
                () -> assertThat(lotto.checkedNumber().get(4)).isLessThan(lotto.checkedNumber().get(5)),
                () -> assertThat(lotto.checkedNumber().get(5)).isGreaterThan(lotto.checkedNumber().get(4))
        );
    }

    @Test
    @DisplayName("checkLottoNumber")
    public void checkLottoNumberTest() {
        Lotto lotto = new Lotto();
        List<Integer> targetNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> lottoNumber = lotto.checkedNumber();
        int result = lotto.checkLottoNumber(targetNumber);

        int result2 = 0;

        for(int target : targetNumber) {
            if(lottoNumber.contains(target)) {
                result2++;
            }
        }

        assertThat(result).isEqualTo(result2);
    }
}
