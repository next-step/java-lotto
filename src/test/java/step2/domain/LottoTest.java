package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private final List<LottoNumber> COMMON_INPUT =
            List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            );

    @Test
    @DisplayName("로또는 6개의 숫자를 가진다.")
    void create() {
        Lotto lotto = new Lotto(COMMON_INPUT);
        assertThat(lotto.lottoNumbers()).hasSize(6);
    }
}
