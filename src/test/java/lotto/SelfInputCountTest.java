package lotto;

import lotto.domain.SelfInputCount;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SelfInputCountTest {
    @Test
    @DisplayName("매개변수로 전달된 값과 가지고 있는 값이 같을때만 true 를 반환한다.")
    void test() {
        //Given
        SelfInputCount selfInputCount = new SelfInputCount(1);
        boolean same = selfInputCount.isSame(1);
        boolean different = selfInputCount.isSame(2);
        Assertions.assertThat(same).isTrue();
        Assertions.assertThat(different).isFalse();
    }
}
