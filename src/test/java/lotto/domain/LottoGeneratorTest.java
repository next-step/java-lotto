package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    private String values = "1,2,3,4,5,6\n1,2,3,4,5,6\n1,2,3,4,5,6";

    @ParameterizedTest
    @CsvSource(value = {"5:5", "3:3"}, delimiter = ':')
    void 자동_로또_리스트_생성(int input, int result) {
        assertThat(LottoGenerator.autoGenerate(input)
                .size())
                .isEqualTo(result);
    }

    @Test
    void 수동_로또_리스트_생성() {
        String[] tmp = values.split("\n");
        assertThat(LottoGenerator.manualGenerate(tmp)
                .size())
                .isEqualTo(tmp.length);
    }


    @ParameterizedTest
    @CsvSource(value = {"5000:5", "10000:10"}, delimiter = ':')
    void 로또_리스트_생성(int input, int result) {
        Amount amount = new Amount(input, values.split("\n").length);
        PrePurchaseInformation prePurchaseInformation = new PrePurchaseInformation(amount, values);

        assertThat(LottoGenerator.generate(prePurchaseInformation)
                .size())
                .isEqualTo(result);
    }
}
