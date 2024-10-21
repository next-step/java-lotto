package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void 생성자() {
        WinningLotto expected = new WinningLotto(new Lotto("1,2,3,4,5,6"), new LottoNumber(7));

        assertThat(expected).isEqualTo(new WinningLotto(List.of(1,2,3,4,5,6), 7));
    }

}
