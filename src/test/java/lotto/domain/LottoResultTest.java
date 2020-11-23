package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        this.lotto = new Lotto(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))
        );
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:10:FIRST",
            "1,2,3,4,5,9:5:SECOND",
            "1,2,3,4,5,9:10:THIRD",
            "1,2,3,4,8,9:10:FOURTH",
            "1,2,3,7,8,9:10:FIFTH"
    }, delimiter = ':')
    @DisplayName("Lotto 당첨번호+보너스번호 등수 확인")
    void lottoResult_winningNumber_matchOfCount(String lottoNumber,String winningNumber, String rank) {
        LottoResult lottoResult = LottoResult.check(lotto,lottoNumber,Integer.parseInt(winningNumber));
        assertThat(lottoResult).isEqualTo(LottoResult.valueOf(rank));
    }
}
