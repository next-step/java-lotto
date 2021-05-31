package lotto.util;

import lotto.domains.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConvertorTest {
    @Test
    void 스트링_리스트_반환_테스트() {
        assertThat(Convertor.convertStringToList("1,2,3,4,5,6")).contains(LottoNumber.of(1));
        assertThat(Convertor.convertStringToList("1, 2, 3, 4, 5, 6")).contains(LottoNumber.of(1));
    }
}