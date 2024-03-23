package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

}
