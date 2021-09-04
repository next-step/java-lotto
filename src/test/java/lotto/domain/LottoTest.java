package lotto.domain;

import lotto.exception.DuplicateNumberException;
import lotto.exception.InvalidNumberException;
import lotto.exception.NumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    @DisplayName("생성될 로또 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void create_list_exception() {
        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));

        assertThatExceptionOfType(NumberCountException.class).isThrownBy(
                () -> new Lotto(numbers));
    }

    @DisplayName("지난주 당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void create_string_exception() {
        String lastWeekNumber = "1,2,3";
        assertThatExceptionOfType(NumberCountException.class).isThrownBy(
                () -> new Lotto(lastWeekNumber));
    }

    @DisplayName("지난주 당첨번호가 1 ~ 45 외의 숫자면 예외가 발생한다.")
    @Test
    void invalidLottoNumberException() {
        String lastWeekNumber = "11,22,33,44,55,66";

        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(
                () -> new Lotto(lastWeekNumber));
    }

    @DisplayName("지난주 당첨번호에 중복 번호가 존재하면 예외가 발생한다.")
    @Test
    void duplicateLastWeekLottoNumberException() {
        String lastWeekNumber = "1,1,1,1,1,1";

        assertThatExceptionOfType(DuplicateNumberException.class).isThrownBy(
                () -> new Lotto(lastWeekNumber));
    }

    @DisplayName("로또 번호 생성 시 중복 번호가 존재하면 예외가 발생한다.")
    @Test
    void createDuplicateLottoNumberException() {
        List<LottoNumber> numbers = new ArrayList<>();
        numbers.add(new LottoNumber(1));
        numbers.add(new LottoNumber(2));
        numbers.add(new LottoNumber(3));
        numbers.add(new LottoNumber(44));
        numbers.add(new LottoNumber(44));
        numbers.add(new LottoNumber(45));

        assertThatExceptionOfType(DuplicateNumberException.class).isThrownBy(
                () -> new Lotto(numbers));
    }
}