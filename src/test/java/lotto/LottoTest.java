package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("입력 받은 금액 / 1000 만큼 구매")
    public void buyLottoCount(){
        assertThat(lotto.buyCount(15000)).isEqualTo(15);
    }
}
