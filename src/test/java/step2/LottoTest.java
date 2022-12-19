package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("두개 로또 번호 비교해서 몇개 일치하는지 테스트")
    public void matchCountTest() {
        Lotto lotto1 = new Lotto(new Integer[]{1, 2, 3, 4, 5, 6});
        Lotto lotto2 = new Lotto(new Integer[]{4, 5, 6, 7, 8, 9});

        int matchCount = lotto1.matchCount(lotto2);

        assertThat(matchCount).isEqualTo(3);
    }

}
