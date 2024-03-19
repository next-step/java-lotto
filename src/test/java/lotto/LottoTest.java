package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoTest {

    @DisplayName("겹치지 않는 로또 번호 6개를 가질 수 있다.")
    @Test
    void name() {
        Lotto lotto = Lotto.create(() -> List.of(5, 6, 7, 8, 9, 10));
        Assertions.assertThat(lotto.numbers()).containsExactly(new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10));
    }
}
