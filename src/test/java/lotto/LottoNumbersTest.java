package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


class LottoNumbersTest {

    @Test
    @DisplayName("문자열 번호로 로또 번호 생성")
    public void stringInputTest() {
        LottoNumbers sut = new LottoNumbers("1,2,3,4,5,6");
        assertThat(sut.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

}