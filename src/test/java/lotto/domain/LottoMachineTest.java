package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachineTest {
    static LottoMachine lottoMachine;

    @BeforeAll
    static void initAll() {
        lottoMachine = new LottoMachine();
    }

    @Test
    void getLottoTicketNumberTest() {
        Assertions.assertThat(lottoMachine.getLottoTicketNumber(14000)).isEqualTo(14);
    }

    @Test
    void createLottoTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(lottoMachine.createLotto(lottoNumbers).getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @Test
    void createLottoDuplicatedNumberFailureTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 3, 5, 6);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.createLotto(lottoNumbers));
    }

    @Test
    void createLottoOutOfRangeNumberFailureTest() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 3, 5, 100);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lottoMachine.createLotto(lottoNumbers));
    }

    @Test
    void generateLottos() {
        lottoMachine.initializeLottoCount(3000, 0);
        List<Lotto> lottos = lottoMachine.generateLottos(new ArrayList<>());
        Assertions.assertThat(lottos.size()).isEqualTo(1);
    }
}
