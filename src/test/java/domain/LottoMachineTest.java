package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void 구입_금액에_맞는_갯수의_자동_로또를_반환한다() {
        LottoGames games = lottoMachine.purchaseLotto(new Money(14500), Collections.emptyList());

        assertThat(games.getGames()).hasSize(14);
    }

    @Test
    public void 자동_수동_섞어서_로또를_구입한다() {
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("1,2,3,4,5,6");

        LottoGames games = lottoMachine.purchaseLotto(new Money(14500), manualNumbers);

        assertThat(games.getGames()).hasSize(14);
        assertThat(games.getAutoGameCount()).isEqualTo(11);
        assertThat(games.getManualGameCount()).isEqualTo(3);
    }
}