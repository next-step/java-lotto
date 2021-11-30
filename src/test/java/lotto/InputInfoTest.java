package lotto;

import lotto.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputInfoTest {

    @Test
    void getTicket() {
        InputInfo inputInfo = new InputInfo("5000");
        Assertions.assertThat(inputInfo.getTicketCount()).isEqualTo(5);
    }
}
