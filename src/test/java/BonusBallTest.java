import domain.BonusBall;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class BonusBallTest {
    
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void 범위벗어난보너스볼_생성에러_테스트(int number) {
        assertThatThrownBy(() -> new BonusBall(number)).isInstanceOf(IllegalArgumentException.class);
    }

}
