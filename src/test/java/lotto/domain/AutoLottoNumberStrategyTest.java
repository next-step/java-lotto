package lotto.domain;

import lotto.infrastructure.AutoLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberStrategyTest {

    @DisplayName("로또 번호를 자동으로 생성할 수 있다")
    @Test
    public void generateLottoNumbersTest() {
        LottoNumber lottoNumber = new AutoLottoNumberStrategy().get();
        String numberToString = lottoNumber.getNumberToString();
        String substring = numberToString.substring(1, numberToString.length() - 1);

        List<Integer> lottoNumbers = Arrays.asList(substring.split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        assertThat(lottoNumbers)
                .filteredOn(number -> 1 <= number && number <= 45)
                .size().isEqualTo(6);
    }

}
