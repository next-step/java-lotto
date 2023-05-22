package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyLottoTest {

    @Test
    void 로또_구매() {
        MyLotto myLotto = new MyLotto(14000);

        Assertions.assertThat(myLotto.lottoCountIsEqualTo(14)).isTrue();
    }
}
