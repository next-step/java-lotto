import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageTest {
    @Test
    public void sumBodyTest() {
        Message message = new Message(null, "1,2,3");
        int sumBody = message.sumBody();
        assertThat(sumBody).isEqualTo(6);
    }

    @Test
    public void customDelimiterSumBodyTest() {
        Message message = new Message(";", "1;2;3;");
        int sumBody = message.sumBody();
        assertThat(sumBody).isEqualTo(6);
    }
}
