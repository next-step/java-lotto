package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {"3:3", "4:4"}, delimiter = ':')
    void 로또_리스트_생성(int input, int result) {
        assertThat(LottoGenerator.generate(input)
                .size())
                .isEqualTo(result);
    }
}