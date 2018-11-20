package lotto;

import lotto.domain.Lotto;
import org.junit.Test;

import java.util.Arrays;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 중복값() {
        Lotto.from(Arrays.asList(1, 2, 3, 4, 5));
    }


}
