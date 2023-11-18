package lotto.type;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SingleNumberTest {
    @Test
    @DisplayName("[new SingleNumber] 상한선/하한선 테스트")
    public void boundTest() {
        assertThatIllegalArgumentException()
                .as("SingleNumber는 1 미만으로 생성될 수 없음")
                .isThrownBy(() -> {
                    new SingleNumber(0);
                });

        assertThatIllegalArgumentException()
                .as("SingleNumber는 45 초과로 생성될 수 없음")
                .isThrownBy(() -> {
                    new SingleNumber(46);
                });
    }
}
