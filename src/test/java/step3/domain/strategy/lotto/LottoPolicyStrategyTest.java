package step3.domain.strategy.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.ProfitCalculatorService;
import step2.domain.model.Lotto.Lottos;

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
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);

        assertThatThrownBy(() -> lottoPolicyStrategy.createManualLottoNumbers(integerList))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 로또_중복값_테스트() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);
        integerList.add(1);

        assertThatThrownBy(() -> lottoPolicyStrategy.createManualLottoNumbers(integerList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}