package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("생성된 번호가 모두 1 ~ 45 사이의 번호이다.")
    void checkNumberRangeTest() {
        //Given
        Lotto lotto = new Lotto();
        //When
        boolean numberRangeChecked = lotto.checkNumberRange();
        //Then
        Assertions.assertThat(numberRangeChecked).isTrue();
    }
    
    @Test
    @DisplayName("생성된 번호 중 중복되는 번호가 없다.")
    void duplicateNumberTest() {
        //Given
        Lotto lotto = new Lotto();
        //When
        boolean numberRangeChecked = lotto.checkDuplicateNumber();
        //Then
        Assertions.assertThat(numberRangeChecked).isFalse();
    }
}
