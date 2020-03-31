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
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
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
    public void test_fail_inputNullParam() throws Exception {
        //given
        ArrayList<LottoNumber> emptyNumber = new ArrayList<>();
        assertThatThrownBy(
                () -> new Lotto(null)
        ).isInstanceOf(ValidLottoException.class);
    }

    @DisplayName("로또는 불변 VO 객체여야 한다")
    @Test
    public void constructor_fail_modify() throws Exception {
        //given
        Lotto ticket = new Lotto(numbers);

        //when
        List<LottoNumber> numbers = ticket.getNumbers();

        //then
        assertThatThrownBy(
                () -> numbers.set(0, new LottoNumber(11))
        ).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또번호는 외부의 변화에 영향이 없어야 한다.")
    @Test
    public void constructor_fail_modifyFromOutside() throws Exception {
        //given
        Lotto ticket = new Lotto(numbers);

        //when
        numbers.set(0, new LottoNumber(10));

        //then
        assertAll(
                () -> assertThat(ticket.getNumbers().get(0))
                        .isNotEqualTo(numbers.get(0))
        );
    }

    @DisplayName("번호 중복 체크")
    @Test
    public void validateDuplicate_fail() throws Exception {
        //given
        ArrayList<LottoNumber> duplicateNumber =
                new ArrayList<>(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)));

        assertThatThrownBy(
                () -> new Lotto(duplicateNumber)
        ).isInstanceOf(ValidLottoException.class).hasMessage("로또생성 실패 : 번호는 중복될 수 없습니다.");
    }
}
