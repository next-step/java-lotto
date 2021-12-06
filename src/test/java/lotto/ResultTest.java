package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultTest {

    @Test
    void 당첨결과_테스트() {
        List<Lotto> sampleLottos = new ArrayList<>();
        InputInfo inputInfo = new InputInfo("1000");

        sampleLottos.add(Lotto.newInstance(inputInfo.getAnswer("1,2,3,4,5,6")));
        sampleLottos.add(Lotto.newInstance(inputInfo.getAnswer("11,12,13,14,15,16")));
        sampleLottos.add(Lotto.newInstance(inputInfo.getAnswer("21,22,23,24,25,26")));
        sampleLottos.add(Lotto.newInstance(inputInfo.getAnswer("31,32,33,34,35,36")));
        sampleLottos.add(Lotto.newInstance(inputInfo.getAnswer("40,41,42,43,44,45")));

        Lottos lottos = new Lottos(sampleLottos);
        Result result = new Result(lottos, Lotto.newInstance(inputInfo.getAnswer("1,2,3,7,8,9")));
        Map<Integer, Integer> sampleResult = new HashMap<>();

        sampleResult.put(0,0);
        sampleResult.put(3,1);
        sampleResult.put(4,0);
        sampleResult.put(5,0);
        sampleResult.put(6,0);

        // 결과 내용
        Assertions.assertThat(result.getResultInfo()).isEqualTo(sampleResult);
        // 수익금
        Assertions.assertThat(result.getRateOfReturn()).isEqualTo(1);
    }
}
