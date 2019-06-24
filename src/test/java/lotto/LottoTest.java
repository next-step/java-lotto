package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LottoTest {
    @Test
    @DisplayName("실패 : 생성된 번호 중 중복되는 번호가 없다.")
    void duplicateNumberFailTest() {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 1, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(lottoNumbers))
            .withMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.message());
    }
    
    @Test
    @DisplayName("실패 : 생성된 번호가 6개가 아니다.")
    void numbersCountTest() {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 1, 3, 4, 5, 6, 7).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new Lotto(lottoNumbers))
            .withMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.message());
    }
}
