package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("보너스 번호가 일치하면 true반환")
    @ParameterizedTest
    @CsvSource(value = {"1:true","3:true", "5:true", "7:false"}, delimiter = ':')
    void 보너스번호_확인(String number, boolean expectedFlag) {
        List<LottoNumber> parameter = new ArrayList<>(Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6)));
        assertThat(new LottoNumber(number).belongs(parameter)).isEqualTo(expectedFlag);
    }

    @DisplayName("보너스 번호가 일치하면 true반환")
    @Test
    void 번호_확인() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}