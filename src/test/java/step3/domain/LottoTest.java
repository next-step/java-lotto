package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    Lotto lottoFixture(Integer... numbers) {
        return new Lotto(List.of(
                LottoNumber.of(numbers[0]),
                LottoNumber.of(numbers[1]),
                LottoNumber.of(numbers[2]),
                LottoNumber.of(numbers[3]),
                LottoNumber.of(numbers[4]),
                LottoNumber.of(numbers[5])
        ));
    }

    @Test
    @DisplayName("로또는 중복되지 않는 6개의 숫자로 만들수 있다.")
    void create() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoFixture(1,2,3,4,5,5));
    }



}
