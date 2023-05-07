package step3.domain.strategy.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.ProfitCalculatorService;
import step2.domain.model.Lotto.Lottos;
import step3.param.ManualLottoNumberParam;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoPolicyStrategyTest {
    LottoPolicyStrategy lottoPolicyStrategy;

    @BeforeEach
    void setLottoPolicyStrategy() {
        this.lottoPolicyStrategy = new LottoPolicyStrategy();
    }

    @Test
    void 로또_갯수_테스트() {
        List<ManualLottoNumberParam> integerList = new ArrayList<>();
        integerList.add(new ManualLottoNumberParam(1));
        integerList.add(new ManualLottoNumberParam(2));
        integerList.add(new ManualLottoNumberParam(3));
        integerList.add(new ManualLottoNumberParam(4));
        integerList.add(new ManualLottoNumberParam(5));
        integerList.add(new ManualLottoNumberParam(6));
        integerList.add(new ManualLottoNumberParam(7));

        assertThatThrownBy(() -> lottoPolicyStrategy.createManualLottoNumbers(integerList))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 로또_중복값_테스트() {
        List<ManualLottoNumberParam> integerList = new ArrayList<>();
        integerList.add(new ManualLottoNumberParam(1));
        integerList.add(new ManualLottoNumberParam(1));
        integerList.add(new ManualLottoNumberParam(1));
        integerList.add(new ManualLottoNumberParam(1));
        integerList.add(new ManualLottoNumberParam(1));
        integerList.add(new ManualLottoNumberParam(1));

        assertThatThrownBy(() -> lottoPolicyStrategy.createManualLottoNumbers(integerList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}