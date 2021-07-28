package lotto.domain;

import lotto.exception.OutOfRangeException;
import lotto.exception.OutOfSizeException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @ValueSource(strings = {
            "1,10,20,30,40,45"
    })
    @ParameterizedTest
    public void lottoTest_생성자(String strNumbers) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(strNumbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        assertThat(
                new Lotto(lottoNumbers)
        ).isNotNull();
    }

    // Lotto의 size 메소드를 테스트 후 제거할것
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7"
    })
    @ParameterizedTest
    public void lottoTest_생성자_유효성에러_OutOfSizeException(String strNumbers) {
        assertThatThrownBy(() ->
                lottoTest_생성자(strNumbers)
        ).isInstanceOf(OutOfSizeException.class);
    }
}
