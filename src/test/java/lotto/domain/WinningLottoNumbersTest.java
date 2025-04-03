package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class WinningLottoNumbersTest {
    @Test
    @DisplayName("당첨 번호와 보너스 번호가 중복이면 예외를 반환한다.")
    void validateDuplicationTest() {
        List<LottoNumber> winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(1);

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLottoNumbers(winningNumbers, bonusNumber));
    }

}
