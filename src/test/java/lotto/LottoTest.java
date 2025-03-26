package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {

    @Test
    @DisplayName("로또는 생성될때 숫자 6자리를 입력 받아 생성된다.")
    void lottoCreateTest() {
        var lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Assertions.assertThat(lotto).isInstanceOf(Lotto.class);
    }
}
