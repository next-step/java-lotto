package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {


    @Test
    void 생성test() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(integerList);

        assertThat(lotto.getLottoIntegerList()).isEqualTo(integerList);
    }

    @Test
    void 숫자가6이_아니면_생성실패() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6,7);
        List<Integer> integerList2 = Arrays.asList(1, 2, 3, 4);
        assertThatIllegalArgumentException().isThrownBy(()->{
            Lotto lotto = Lotto.of(integerList);
                });

        assertThatIllegalArgumentException().isThrownBy(()->{
            Lotto lotto = Lotto.of(integerList2);
        });
    }

    @Test
    void cotainsTest() {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(integerList);

        assertThat(lotto.contains(LottoNumber.of(1))).isTrue();
        assertThat(lotto.contains(LottoNumber.of(8))).isFalse();
    }
}
