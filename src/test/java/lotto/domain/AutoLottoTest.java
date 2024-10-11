package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTest {

    @Test
    @DisplayName("리스트를 셔플한 뒤 임의의 숫자를 담은 로또 객체를 반환한다.")
    void 임의의_숫자_셔플() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        assertThat(AutoLotto.getInstance().getLotto(list, 6)).isEqualTo(new Lotto(list));
    }
}
