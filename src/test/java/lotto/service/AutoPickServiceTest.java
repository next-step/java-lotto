package lotto.service;

import lotto.domain.Pick;
import lotto.domain.enums.PickType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoPickServiceTest {

    @Test
    void autoPick(){
        AutoPickService autoPickService = new AutoPickService();
        Pick pick = autoPickService.pick();
        assertThat(pick.getType()).isEqualTo(PickType.AUTO);
        assertThat(pick.getBalls()).hasSize(6);
    }
}
