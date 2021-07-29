package lotto.domain;

import lotto.exception.OutOfSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @DisplayName("newManual Test")
    @ValueSource(strings = {
            "1,10,20,30,40,45"
    })
    @ParameterizedTest
    public void newManualTest(String strNumbers) {
        Set<LottoNumber> lottoNumbers = Arrays.stream(strNumbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        assertThat(
                Lotto.newManual(lottoNumbers)
        ).isNotNull();
    }

    @DisplayName("newManual Test - OutOfSizeException")
    @ValueSource(strings = {
            "1,2,3,4,5",
            "1,2,3,4,5,6,7"
    })
    @ParameterizedTest
    public void newManualTest_OutOfSizeException(String strNumbers) {
        assertThatThrownBy(() ->
                newManualTest(strNumbers)
        ).isInstanceOf(OutOfSizeException.class);
    }

    @DisplayName("newAuto Test")
    @Test
    public void newAutoTest() {
        Lotto.newAuto();
    }

    @CsvSource( value = {
            "1,2,3,4,5,6|1,2,3,4,5,6|FIRST_PLACE",
            "1,2,3,4,5,6|1,2,3,4,5,7|SECOND_PLACE",
            "1,2,3,4,5,6|1,2,3,4,7,8|THREE_PLACE",
            "1,2,3,4,5,6|1,2,3,7,8,9|FOUR_PLACE"
    }, delimiter = '|')
    @DisplayName("rank Test")
    @ParameterizedTest
    public void rankTest(String strLottoNumbers, String strPrizeLottoNumbers, String rankName) {
        Lotto lotto = Lotto.parse(strLottoNumbers);
        Lotto prizeLotto = Lotto.parse(strPrizeLottoNumbers);

        LottoRank expertRank = LottoRank.valueOf(rankName);

        assertThat(lotto.rank(prizeLotto))
                .isEqualTo(expertRank);
    }
}
