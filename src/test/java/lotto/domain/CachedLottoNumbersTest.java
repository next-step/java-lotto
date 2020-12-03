package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CachedLottoNumbersTest {

    public static final CachedLottoNumbers cachedLottoNumbers = new CachedLottoNumbers();

    @Test
    @DisplayName("주어진 lottoCount만큼의 저장된 lotto 번호들을 반환한다.")
    void should_return_cached_lotto_numbers() {
        //Given
        int lottoCount = 10;

        //When
        List<LottoNumbers> lottoNumbers = cachedLottoNumbers.getLottoNumbers(lottoCount);

        //Then
        assertThat(lottoNumbers.size()).isEqualTo(lottoCount);
    }

    @Test
    @DisplayName("숫자를 입력받으면, 저장된 LottoNumber를 반환한다.")
    void should_return_cached_lotto_number(){
        //Given
        int number = 10;

        //When
        LottoNumber lottoNumber = cachedLottoNumbers.getLottoNumber(number);

        //Then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
    }
}