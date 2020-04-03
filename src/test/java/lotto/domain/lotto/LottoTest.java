package lotto.domain.lotto;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final String NULL_ERROR_MESSAGE = "로또생성 실패 : 매개변수:null";
    private List<LottoNumber> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    @DisplayName("로또 티켓 정상 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        Lotto ticket1 = new Lotto(numbers);
        Lotto ticket2 = new Lotto(numbers);

        assertThat(ticket1.equals(ticket2)).isTrue();
    }

    @DisplayName("null 매개변수가 넘어올 경우")
    @Test
    public void constructor_fail_inputNullParam() throws Exception {
        //given
        List<LottoNumber> nullValue = null;
        assertThatThrownBy(
                () -> new Lotto(nullValue)
        ).isInstanceOf(ValidLottoException.class).hasMessage(NULL_ERROR_MESSAGE);
    }
}
