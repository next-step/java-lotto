package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void buyAuto() {
        LottoAuto.buyAuto(14000);
        assertThat("14개를 구매했습니다.").isEqualTo(outputStreamCaptor.toString().trim());
    }

    @Test
    void createLottoNumbers() {
        assertThat(LottoAuto.createLottoNumbers()).hasSize(6);
    }

}
