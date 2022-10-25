package lottoGame.model;

import lottoGame.dto.ResultParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.lotto.Lotto;
import lottoGame.model.strategy.TestShuffleStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultParameterTest {

    @Test
    void getLotteryCount(){
        List<Lotto> lottos = new Lottery().create(14, new TestShuffleStrategy());
        ResultParameter resultParameter = new ResultParameter(lottos);
        assertEquals(resultParameter.getLotteryCount(),lottos.size());
    }
}
