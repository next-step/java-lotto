package lotto.domain.item;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private List<LottoNumber> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    @DisplayName("로또 번호 리스트를 생성한다.")
    @Test
    public void constructor_success() throws Exception {
        //given
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumbers compare = new LottoNumbers(numbers);

        //then
        assertThat(lottoNumbers.equals(compare)).isTrue();
    }

    /**
     * lottosize(), lottosize2() 테스트 코드를 합칠순 없을지...
     */
    @DisplayName("로또 티켓은 번호 6개만 지정 가능")
    @Test
    public void validateSize_fail_lessThan6() throws Exception {
        //given
        numbers.remove(0);

        //then
        assertThatThrownBy(
                () -> new LottoNumbers(numbers)
        ).isInstanceOf(ValidLottoException.class)
                .hasMessage("로또생성 실패 : 번호는 6개만 지정 가능 합니다.");
    }
}
