package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_생성_간_범위를_벗어난_경우() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(0, 1, 2, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_6개_미만으로_생성_시도할_경우() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_당첨번호_비교() {
        assertThat(new Lotto(Arrays.asList(1,2,3,4,5,6))
                .compareSameNumberList(new Lotto(Arrays.asList(1,2,3,4,5,6)))).hasSize(6);
    }

}