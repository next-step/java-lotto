package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("뒤섞인 로또 번호 불변성 확인")
    void shuffleNumbers() {
        assertThatThrownBy(() -> {
            List<Integer> shuffledLottoNumbers = LottoNumber.shuffleNumbers();
            shuffledLottoNumbers.add(5);
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("로또 번호 유효성 검증")
    void validateLottoNumber() {
        assertThat(LottoNumber.validateLottoNumber(new TreeSet<Integer>(Arrays.asList(4, 11, 17, 28, 31, 43)))).isTrue();

        assertThat(LottoNumber.validateLottoNumber(new TreeSet<Integer>(Arrays.asList(46, 47, 48, 49, 999, 1000)))).isFalse();
        assertThat(LottoNumber.validateLottoNumber(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))).isFalse();
    }

    @Test
    @DisplayName("로또 번호 목록 유효성 검증")
    void validateLottoNumbers() {
        List<NavigableSet<Integer>> invalidTickets = new ArrayList<>();
        invalidTickets.add(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        invalidTickets.add(new TreeSet<Integer>(Arrays.asList(4, 11, 17, 28, 31, 43)));

        assertThat(LottoNumber.validateLottoNumber(invalidTickets)).isFalse();
    }

    @Test
    @DisplayName("로또 번호 목록 예외 검증")
    void validateLottoNumbersException() {
        assertThatThrownBy(() -> LottoNumber.validateLottoNumber(new ArrayList<>())).isInstanceOf(IllegalArgumentException.class);
    }
}
