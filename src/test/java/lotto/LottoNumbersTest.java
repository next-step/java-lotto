package lotto;

import lotto.common.ErrorMessage;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumber;
import lotto.domain.WanLottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class LottoNumbersTest {
    @Test
    @DisplayName("실패 : 생성된 번호 중 중복되는 번호가 없다.")
    void duplicateNumberFailTest() {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 1, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        //Then
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy(() -> new LottoNumbers(lottoNumbers))
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
            .isThrownBy(() -> new LottoNumbers(lottoNumbers))
            .withMessage(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR.message());
    }
    
    @Test
    @DisplayName("당첨번호와 몇 개의 번호가 일치하는지 구한다.")
    void test() {
        //Given
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        WanLottoNumbers wanLottoNumbers = new WanLottoNumbers("1,2,3,7,8,9");
        LottoNumbers lotto = new LottoNumbers(lottoNumbers);
        //When
        int matchedCount = lotto.getMatchedNumberCount(wanLottoNumbers.getLotto());
        //Then
        Assertions.assertThat(matchedCount).isEqualTo(3);
    }
}
