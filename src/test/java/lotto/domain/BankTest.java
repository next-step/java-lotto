package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {
    private Lotto answerLotto;

    @BeforeEach
    void setUp() {
        answerLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
    }

    @DisplayName("일치하는 갯수에 맞게 상금이 산정 되는지")
    @ParameterizedTest
    @CsvSource({"1, 2, 3, 4, 5, 6, 6, 2000000000",
            "1, 2, 3, 4, 5, 45, 5, 1500000",
            "1, 2, 3, 4, 44, 45, 4, 50000",
            "1, 2, 3, 43, 44, 45, 3, 5000",
            "40, 41, 42, 43, 44, 45, 0, 0"
    })
    void lotto_result(final int lottoNumber1, final int lottoNumber2, final int lottoNumber3,
                      final int lottoNumber4, final int lottoNumber5, final int lottoNumber6,
                      final int expectedMatchCount, final int expectedReward) {
        //given
        Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(lottoNumber1), new LottoNumber(lottoNumber2), new LottoNumber(lottoNumber3),
                new LottoNumber(lottoNumber4), new LottoNumber(lottoNumber5), new LottoNumber(lottoNumber6)
        ));

        //when
        Bank bank = new Bank(answerLotto);
        LottoResult result = bank.matchLotto(toCompareLotto);

        //then
        assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.getReward()).isEqualTo(expectedReward);
    }
}
