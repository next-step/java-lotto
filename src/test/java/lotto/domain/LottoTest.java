package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    List<LottoNumber> numbers;

    @BeforeEach
    void setup() {
        numbers = new ArrayList<>();
        numbers.add(LottoNumber.of(1));
        numbers.add(LottoNumber.of(2));
        numbers.add(LottoNumber.of(3));
        numbers.add(LottoNumber.of(4));
        numbers.add(LottoNumber.of(5));
        numbers.add(LottoNumber.of(6));
    }

    @DisplayName("LottoNumbers 생성")
    @Test
    void create() {
        Lotto lotto = Lotto.of(numbers);
        assertThat(lotto).isEqualTo(Lotto.of(numbers));
    }

    @DisplayName("로또 번호 6개 미만 에러")
    @Test
    void createError() {
        numbers.remove(1);
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(numbers));
    }

    @DisplayName("로또 번호 중복 에러")
    @Test
    void duplicatedNumberError() {
        numbers.add(LottoNumber.of(6));
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(numbers));
    }
}