package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @CsvSource({
            "1,10,20,30,40,45"
    })
    @ParameterizedTest
    public void lottoTest_생성자(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers =
                numbers.stream()
                        .map(LottoNumber::new)
                        .collect(Collectors.toSet());

        assertThat(
                new Lotto(lottoNumbers)
        ).isNotNull();
    }

    // Lotto의 size 메소드를 테스트 후 제거할것
    @CsvSource({
            "0, 2, 3, 4, 5, 45",
            "1, 2, 3, 4, 5, 46",
            "1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 6, 7"
    })
    @ParameterizedTest
    public void lottoTest_생성자_유효성에러(List<Integer> numbers) {
        assertThatThrownBy(() ->
            lottoTest_생성자(numbers)
        );
    }
}
