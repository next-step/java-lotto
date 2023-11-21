package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BonusNumberTest {
    @DisplayName("보너스 번호가 일치하면 true반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true","3:true", "5:true", "7:false"}, delimiter = ':')
    void 보너스번호_확인(String number, boolean expectedFlag) {
        List<Integer> parameter = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        assertThat(new BonusNumber(number).belongs(parameter)).isEqualTo(expectedFlag);
    }
}