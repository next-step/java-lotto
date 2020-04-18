package Lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {

    @Test
    public void addManualLottoNumbersTest() {
        String manual = "1,2,3,4,5,6";
        LottoPaper lottoPaper = new LottoPaper(manual);

        assertThat(lottoPaper.getSize()).isEqualTo(6);
        assertThat(lottoPaper.getNumber(5)).isEqualTo(6);
    }
}
