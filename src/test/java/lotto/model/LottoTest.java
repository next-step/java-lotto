package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_생성(){
        assertThat(new Lotto(List.of(1,2,3,4,5,6))).isEqualTo(new Lotto(List.of(1,2,3,4,5,6)));
    }

}
