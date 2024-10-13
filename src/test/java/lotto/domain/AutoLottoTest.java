package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTest {

    @Test
    @DisplayName("리스트를 셔플한 뒤 임의의 숫자를 담은 로또 객체를 반환한다.")
    void 임의의_숫자_셔플() {
        List<LottoNum> list = List.of(new LottoNum(1), new LottoNum(2), new LottoNum(3), new LottoNum(4), new LottoNum(5), new LottoNum(6));
        assertThat(AutoLotto.getInstance().getLotto(list, 6)).isEqualTo(new Lotto(list));
    }
}
