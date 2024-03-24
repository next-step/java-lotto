package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.exception.DuplicateLottoNumbersException;
import lotto.exception.IllegalLottoNumbersSizeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumbersTest {

    @Test
    @DisplayName("[성공] 1부터 45까지의 중복되지 않는 번호를 생성해서 6개의 로또 번호를 생성한다.")
    void 중복되지_않는_번호_생성() {
        LottoNumbers numbers = new LottoNumbers();
        Assertions.assertThat(numbers.get()).containsAnyElementsOf(getPossibleLottoNumbers());
    }

    private Set<LottoNumber> getPossibleLottoNumbers() {
        return IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toUnmodifiableSet());
    }

    @Test
    @DisplayName("[실패] 로또 번호 개수가 6개가 아니면 IllegalLottoNumbersSizeException 예외가 발생한다.")
    void 로또_번호_개수() {
        assertThatExceptionOfType(IllegalLottoNumbersSizeException.class)
                .isThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("[실패] 중복된 로또 번호를 입력하면 DuplicateLottoNumbersException 예외가 발생한다.")
    void 로또_번호_중복() {
        assertThatExceptionOfType(DuplicateLottoNumbersException.class)
                .isThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 5)));
    }

}
