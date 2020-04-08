package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

    List<LottoNumber> numbers;

    @BeforeEach
    void setup() {
        numbers = new ArrayList<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(4));
        numbers.add(new LottoNumber(5));
        numbers.add(new LottoNumber(6));
    }

    @DisplayName("LottoNumbers 생성")
    @Test
    void create() {
        LottoNumbers lottoNumbers = LottoNumbers.create(numbers);
        assertThat(lottoNumbers).isEqualTo(LottoNumbers.create(numbers));
    }

    @DisplayName("로또 번호 6개 미만 에러")
    @Test
    void createError() {
        numbers.remove(1);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.create(numbers));
    }

    @DisplayName("로또 번호 중복 에러")
    @Test
    void duplicatedNumberError() {
        numbers.add(new LottoNumber(6));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.create(numbers));
    }
}