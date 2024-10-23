package lotto;

import lotto.lotto.Lotto;
import lotto.lotto.LottoGeneratorStrategy;
import lotto.lotto.LottoMachine;
import lotto.lotto.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
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
    void 로또_생성_횟수_구하기() {
        LottoMachine lottoMachine = new LottoMachine(3000, lottoGeneratorStrategy);
        assertThat(lottoMachine.getExecuteIdx()).isEqualTo(3);
    }

    @Test
    void 로또_금액은_1000원_미만_IllegalArgumentException() {
        assertThatThrownBy(() -> {
            LottoMachine lottoMachine = new LottoMachine(500, lottoGeneratorStrategy);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_생성_테스트() {
        LottoMachine lottoMachine = new LottoMachine(3000, lottoGeneratorStrategy);
        lottoMachine.createLottos();

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(new LottoNumber(1));
        lottoNumberList.add(new LottoNumber(2));
        lottoNumberList.add(new LottoNumber(3));
        lottoNumberList.add(new LottoNumber(4));
        lottoNumberList.add(new LottoNumber(5));
        lottoNumberList.add(new LottoNumber(10));

        // 각 로또가 횟수만큼 잘 생성하는지 확인
        IntStream.range(0, lottoMachine.getLottos().size()).forEach(idx -> {
            Lotto lotto = lottoMachine.getLottos().get(idx);
            assertThat(lotto.findLottoNumber(idx)).isEqualTo(lottoNumberList.get(idx).getNumber());
        });

        assertThat(lottoMachine.getLottos()).hasSize(3);
    }
}
