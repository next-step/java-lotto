package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    
    @DisplayName("LottoNumber를 정렬된 상태로 반환하는지")
    @Test
    void lottoNumbers() {
        LottoNumber smallNum = new LottoNumber(1);
        LottoNumber middleNum = new LottoNumber(2);
        LottoNumber bigNum = new LottoNumber(3);

        LottoNumbers lottoNumbers = new LottoNumbers(asList(bigNum, smallNum, middleNum));

        assertThat(lottoNumbers.lottoNumbers()).isEqualTo(asList(smallNum, middleNum, bigNum));
    }

}
