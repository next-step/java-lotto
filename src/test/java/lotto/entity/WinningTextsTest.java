package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningTextsTest {

    @Test
    void 당첨_숫자_리스트_반환() {
        String[] texts = {"1", "2", "3", "4", "5", "6"};
        Set<LottoNumber> numbers = WinningTexts.numbers(texts);

        Set<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6).stream().map(number -> new LottoNumber(number)).collect(Collectors.toSet());
        assertAll(
                () -> assertThat(numbers).hasSize(6),
                () -> assertThat(numbers).isEqualTo(lottoNumbers)
        );
    }

}
