package lotto.step2.domain.factory;

import lotto.step2.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersFactoryTest {
    
    @Test
    @DisplayName("처음 로또 번호 리스트 생성")
    void getInstance() {
        List<LottoNumber> actualLottoNumbers = LottoNumbersFactory.getInstance();
        List<LottoNumber> expectedLottoNumbers = IntStream.rangeClosed(1, 45).mapToObj(LottoNumber::new).collect(Collectors.toList());
        assertThat(actualLottoNumbers).isEqualTo(expectedLottoNumbers);
    }
}