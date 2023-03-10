package lotto.domain.strategy;

import lotto.ui.LottoRequest;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoCreationStrategyTest {

    @Test
    void 자동로또생성전략_객체를_생성한다() {

        //given
        LottoRequest request = new LottoRequest(14000, "auto");

        //when
        LottoCreationStrategy actual = LottoCreationStrategyFactory.createLottoStrategy(request);

        //then
        assertThat(actual).isInstanceOf(AutoCreationStrategy.class);
     }

    @Test
    void 수동로또생성전략_객체를_생성한다() {

        //given
        LottoRequest request = new LottoRequest(14000, "manual");

        //when
        LottoCreationStrategy actual = LottoCreationStrategyFactory.createLottoStrategy(request);

        //then
        assertThat(actual).isInstanceOf(ManualCreationStrategy.class);
    }
}
