package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

public class LottoTest {

    @Test
    void size() {
        Lotto lotto = new Lotto();
        List<Integer> list = lotto.getLottoNumbers();
        Assertions.assertThat(list.size()).isEqualTo(6);
    }
}
