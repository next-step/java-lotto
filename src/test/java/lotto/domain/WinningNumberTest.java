package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {

    @DisplayName("번호 리스트에 존재하는 번호인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true","3:true", "5:true", "7:false"}, delimiter = ':')
    void contains(int number, boolean expectedFlag) {
        assertThat(new Lotto("1,2,3,4,5,6").contains(number)).isEqualTo(expectedFlag);
    }
}