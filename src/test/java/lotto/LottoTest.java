package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    Lotto manaulLotto = new Lotto("1,2,3,4,5,6");

    @DisplayName("수동 로또 번호 체크")
    @Test
    void 수동_로또_번호() {
        assertThat(manaulLotto.getLottoNumberList()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}
