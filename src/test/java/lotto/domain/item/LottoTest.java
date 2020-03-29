package lotto.domain.item;

import lotto.exception.ValidLottoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    private List<Integer> numbers;

    private static Stream<Arguments> provideMatchNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 10), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(Arrays.asList(1, 10, 11, 12, 13, 14, 15), 1),
                Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15, 16), 0)
        );
    }

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }


    @DisplayName("로또 티켓 정상 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        Lotto ticket1 = new Lotto(numbers);
        Lotto ticket2 = new Lotto(numbers);

        assertThat(ticket1.equals(ticket2)).isTrue();
    }

    /**
     * lottosize(), lottosize2() 테스트 코드를 합칠순 없을지...
     */
    @DisplayName("로또 티켓은 번호 6개만 지정 가능")
    @Test
    public void validateSize_fail_lessThan6() throws Exception {
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1, 2, 3, 4))
        ).isInstanceOf(ValidLottoException.class).hasMessage("로또생성 실패 : 번호는 6개만 지정 가능 합니다.");
    }

    @DisplayName("로또 티켓은 번호 6개만 지정 가능")
    @Test
    public void validateSize_fail_moreThan6() throws Exception {
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 3, 4, 2))
        ).isInstanceOf(ValidLottoException.class).hasMessage("로또생성 실패 : 번호는 6개만 지정 가능 합니다.");
    }

    @DisplayName("로또는 불변 VO 객체여야 한다")
    @Test
    public void constructor_fail_modify() throws Exception {
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto ticket = new Lotto(list);

        //when
        List<Integer> numbers = ticket.getNumbers();

        //then
        assertThatThrownBy(
                () -> numbers.set(0, 11)
        ).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("로또번호는 외부의 변화에 영향이 없어야 한다.")
    @Test
    public void constructor_fail_modifyFromOutside() throws Exception {
        //given
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto ticket = new Lotto(list);

        //when
        list.set(0, 111);
        System.out.println(ticket.getNumbers());
        System.out.println(list);

        //then
        assertAll(
                () -> assertThat(ticket.getNumbers().get(0)).isEqualTo(1),
                () -> assertThat(list.get(0)).isEqualTo(111)
        );
    }

    @DisplayName("0 ~ 45 사이의 숫자인지 체크")
    @Test
    public void validateNumberRange_fail_1() throws Exception {
        //given
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46))
        ).isInstanceOf(ValidLottoException.class).hasMessage("로또생성 실패 : 번호는 1~ 45 사이의 정수만 가능 합니다.");
    }

    @DisplayName("0 ~ 45 사이의 숫자인지 체크")
    @Test
    public void validateNumberRange_fail_2() throws Exception {
        //given
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(0, 2, 3, 4, 5, 45))
        ).isInstanceOf(ValidLottoException.class).hasMessage("로또생성 실패 : 번호는 1~ 45 사이의 정수만 가능 합니다.");
    }

    @DisplayName("번호 중복 체크")
    @Test
    public void validateDuplicate_fail() throws Exception {
        //given
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1, 1, 3, 4, 5, 45))
        ).isInstanceOf(ValidLottoException.class).hasMessage("로또생성 실패 : 번호는 중복될 수 없습니다.");
    }
}
