package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class TicketTest {

    @Test
    void 숫자_6개() {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> {
                    new Ticket(Arrays.asList(1,2,3,4,5,6,7));
                }).withMessageMatching("로또는 6개의 숫자여야합니다.");
    }

}
