package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TicketTest {

    @DisplayName("로또 숫자가 6가 아니면 예외 발생")
    @Test
    void 숫자_6개() {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    new Ticket(Arrays.asList(1,2,3,4,5,6,7));
                }).withMessageMatching("로또는 6개의 숫자여야합니다.");
    }

}
