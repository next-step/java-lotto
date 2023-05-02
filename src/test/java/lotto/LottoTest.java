package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("lotto 번호 45번까지 잘 만들어지는 지 확인")
    public void allNumberCheck() {
        Lotto lotto = new Lotto();
        List<Integer> result = lotto.checkAllNumber();

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
                () -> assertEquals(lotto.checkNumber().size(), 6),
                () -> assertEquals(lotto1.checkNumber().size(), 6),
                () -> assertEquals(lotto2.checkNumber().size(), 6)
        );

        assertAll("lottoNumber sort",
                () -> assertThat(lotto.checkNumber().get(0)).isLessThan(lotto.checkNumber().get(1)),
                () -> assertThat(lotto.checkNumber().get(1)).isLessThan(lotto.checkNumber().get(2)),
                () -> assertThat(lotto.checkNumber().get(2)).isLessThan(lotto.checkNumber().get(3)),
                () -> assertThat(lotto.checkNumber().get(3)).isLessThan(lotto.checkNumber().get(4)),
                () -> assertThat(lotto.checkNumber().get(4)).isLessThan(lotto.checkNumber().get(5)),
                () -> assertThat(lotto.checkNumber().get(5)).isGreaterThan(lotto.checkNumber().get(4))
        );
    }
}
