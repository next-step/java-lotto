import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 번호 발급 제한")
    public void between_1_to_45() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoNumber.defaultOf(46));
    }
}
