package lotto.domain.lottoNumber;

import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberSetTest {

    @Test
    void create() {
        LottoNumberSet lottoNumberSet = new LottoNumberSet(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumberSet).isEqualTo(new LottoNumberSet(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException를 반환한다.")
    @Test
    void valid_size() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumberSet(1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumberSet(1, 2, 3, 4, 5, 6, 7)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
