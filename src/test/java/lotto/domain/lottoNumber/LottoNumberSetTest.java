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
        LottoNumberSet lottoNumberSet = new LottoNumberSet(
                Set.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );

        assertThat(lottoNumberSet).isEqualTo(new LottoNumberSet(
                Set.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        ));
    }

    @DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException를 반환한다.")
    @Test
    void valid_size() {
        Set<LottoNumber> lottoSizeUnder = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );
        Set<LottoNumber> lottoSizeOver = Set.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumberSet(lottoSizeUnder)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumberSet(lottoSizeOver)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
