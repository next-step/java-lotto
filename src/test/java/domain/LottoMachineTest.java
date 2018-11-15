package domain;

import domain.lottosGenerator.AutoLottosGenerator;
import domain.lottosGenerator.ManualLottosGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void 자동_로또_구입() {
        List<Lotto> games = lottoMachine.purchaseLotto(new Money(5000), new AutoLottosGenerator());

        assertThat(games).hasSize(5);
    }

    @Test
    public void 수동_로또_구입() {
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("1,2,3,4,5,6");

        List<Lotto> games = lottoMachine.purchaseLotto(new Money(5000), new ManualLottosGenerator(manualNumbers));

        assertThat(games).hasSize(3);
    }
}