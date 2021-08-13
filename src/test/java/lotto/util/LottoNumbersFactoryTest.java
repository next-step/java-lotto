package lotto.util;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersFactoryTest {

    @DisplayName("자동 생성")
    @Test
    void makeAutoLottoNumbers_ReturnRandomSixLottoNumbers() {
        LottoNumbers lottoNumbers1 = LottoNumbersFactory.makeAutoLottoNumbers();
        LottoNumbers lottoNumbers2 = LottoNumbersFactory.makeAutoLottoNumbers();
        assertThat(lottoNumbers1).isNotEqualTo(lottoNumbers2);
    }


    @DisplayName("수동 생성")
    @Test
    void makeAutoLottoNumbers_ReturnLottoNumbers_IfInputStringHasSixNumbersAndCommas() {
        String inputLottoNumbers = "1, 5, 7, 13, 27, 38";
        LottoNumbers lottoNumbers = LottoNumbersFactory.makeLottoNumbers(inputLottoNumbers);

        List<LottoNumber> expected = Arrays.stream(inputLottoNumbers.split(","))
                .map(lottoNumber -> Integer.parseInt(lottoNumber.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(expected));
    }

}
