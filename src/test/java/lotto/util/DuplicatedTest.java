package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DuplicatedTest {

    @Test
    @DisplayName("param: int[]의 중복 체크")
    void duplicatedTestIntArray() {
        int[] numbers = {1, 2, 3, 3, 4, 5};
        assertThat(Duplicated.hasDuplicatedNumber(numbers)).isTrue();
    }

    @Test
    @DisplayName("param: String[]의 중복 체크")
    void duplicatedTestStringArray() {
        String[] numbers = {"1", "2", "3", "3"};
        assertThat(Duplicated.hasDuplicatedNumber(numbers)).isTrue();
    }

    @Test
    @DisplayName("param: ListLotto<Number>의 중복 체크")
    void duplicatedTestListLottoNumber() {
        List<LottoNumber> numbers
                = Arrays.asList(LottoNumber.of(1), LottoNumber.of(1), LottoNumber.of(2));
        assertThat(Duplicated.hasDuplicatedNumber(numbers)).isTrue();
    }

}