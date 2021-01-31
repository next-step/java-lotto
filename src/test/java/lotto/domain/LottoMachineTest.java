package lotto.domain;

import com.sun.javafx.binding.SelectBinding;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoMachineTest {
    static LottoMachine lottoMachine;

    @BeforeAll
    static void initAll () {
        lottoMachine = new LottoMachine();
    }

    @Test
    void getLottoTicketNumberTest () {
        Assertions.assertThat(lottoMachine.getLottoTicketNumber(14000)).isEqualTo(14);
    }

    @Test
    void createLottoTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoMachine.createLotto(lottoNumbers).getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test
    void createLottoFailureTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.createLotto(lottoNumbers));
    }

    @Test
    void purchaseLottosTest() {
        int money = 14000;
        Assertions.assertThat(lottoMachine.purchaseLottos(money).size()).isEqualTo(14);
    }

    @Test
    void hasBonusBallTest() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoMachine.hasBonusBall(1, lotto)).isTrue();
        Assertions.assertThat(lottoMachine.hasBonusBall(10, lotto)).isFalse();
    }
}
