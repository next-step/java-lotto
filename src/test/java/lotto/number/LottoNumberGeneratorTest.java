package lotto.number;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.number.LottoNumbers.NUMBER_OF_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기 클래스")
class LottoNumberGeneratorTest {

    @DisplayName("로또 번호 생성기는 자동으로 " + NUMBER_OF_LOTTO_NUMBERS + "개의 로또 번호를 생성해서 반환한다.")
    @Test
    void generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, NUMBER_OF_LOTTO_NUMBERS)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());

        assertThat(LottoNumbers.from(lottoNumbers)).isNotNull();
    }

}
