package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("로또의 입력이 숫자 6개가 아닌경우 예외가 발생한다.")
    void createException() {
        List<LottoNumber> input = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(input));
    }

    @Test
    @DisplayName("로또의 입력에 중복된 숫자가 있는 경우 예외가 발생한다.")
    void createException2() {
        List<LottoNumber> input = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(5)
        );
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(input));
    }

}
