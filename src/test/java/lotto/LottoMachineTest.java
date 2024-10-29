package lotto;

import lotto.lotto.*;
import lotto.lotto.LottoParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private LottoGeneratorStrategy lottoGeneratorStrategy;

    @BeforeEach
    void setUp() {
        lottoGeneratorStrategy = new FakeLottoStrategy();
    }

    @Test
    void 로또_자동_생성_횟수_구하기() {
        LottoMachine lottoMachine = new LottoMachine(3000, 2);
        assertThat(lottoMachine.getAutoCnt()).isEqualTo(1);
    }

    @Test
    void 로또_금액_초과시_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            LottoMachine lottoMachine = new LottoMachine(3000, 4);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_금액은_1000원_미만_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            LottoMachine lottoMachine = new LottoMachine(500, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 자동생성을 주어진 횟수만큼 생성")
    void createLottosAuto() {
        LottoMachine lottoMachine = new LottoMachine(3000, 0);
        LottoGeneratorStrategy autoLottoStrategy = new FakeAutoLottoStrategy();
        Lottos lottos = lottoMachine.createLottos(autoLottoStrategy, new LottoParameters( 3));

        List<LottoNumber> lottoNumberList = compareLottos();

        IntStream.range(0, lottos.getSize()).forEach(idx -> {
            Lotto lotto = lottos.get(idx);
            assertThat(lotto.findLottoNumber(idx)).isEqualTo(lottoNumberList.get(idx).getNumber());
        });

        assertThat(lottos.getSize()).isEqualTo(3);
    }

    private static List<LottoNumber> compareLottos() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(10));
        return lottoNumberList;
    }

    @Test
    @DisplayName("입력한 로또를 수동으로 생성하고 미리 생성해놓은 로또와 값이 같은지 확인")
    void createLottosManual() {
        List<Lotto> compareLottos = new ArrayList<>();
        createCompareLottos(compareLottos);
        LottoMachine lottoMachine = new LottoMachine(3000, 2);
        String[] lottoArray = {"1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 15, 16"};

        ManualLottoStrategy manualLottoStrategy = new ManualLottoStrategy();
        Lottos resultLottos = lottoMachine.createLottos(manualLottoStrategy, new LottoParameters(lottoArray));

        IntStream.range(0, resultLottos.getSize()).forEach(idx -> {
            Lotto lotto = resultLottos.get(idx);
            assertThat(lotto.findLottoNumber(idx)).isEqualTo(compareLottos.get(idx).findLottoNumber(idx));
            assertThat(lotto.getLotto()).hasSize(6);
        });
        assertThat(resultLottos.getSize()).isEqualTo(2);
    }

    private void createCompareLottos(List<Lotto> compareLottos) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(6));
        compareLottos.add(new Lotto(lottoNumberList));
        List<LottoNumber> lottoNumberList2 = new ArrayList<>();
        lottoNumberList2.add(new LottoNumber(11));
        lottoNumberList2.add(new LottoNumber(12));
        lottoNumberList2.add(new LottoNumber(13));
        lottoNumberList2.add(new LottoNumber(14));
        lottoNumberList2.add(new LottoNumber(15));
        lottoNumberList2.add(new LottoNumber(16));
        compareLottos.add(new Lotto(lottoNumberList2));
    }


}
