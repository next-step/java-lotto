package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("print 로 랜덤 값이 들어간 배열이 잘 생성되는지 확인")
    void checkMatchingTest() {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.checkMatching(testList)).isEqualTo(6);

        Lotto lotto2 = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(lotto2.checkMatching(testList)).isEqualTo(5);

        Lotto lotto3 = new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto3.checkMatching(testList)).isEqualTo(3);
    }
}
