package lotto;

import lotto.domain.*;
import lotto.view.InputInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultTest {

    static List<Lotto> sampleLottos;
    static InputInfo inputInfo;
    static Lottos lottos;
    static LottoAnswerFactory factory;

    @BeforeAll
    static void 사전_로또_번호_생성() {
        sampleLottos = new ArrayList<>();
        inputInfo = new InputInfo("1000");
        factory = new LottoAnswerFactory();

        sampleLottos.add(factory.newInstance(inputInfo.getAnswer("1,2,3,4,5,6")));
        sampleLottos.add(factory.newInstance(inputInfo.getAnswer("11,12,13,14,15,16")));
        sampleLottos.add(factory.newInstance(inputInfo.getAnswer("21,22,23,24,25,26")));
        sampleLottos.add(factory.newInstance(inputInfo.getAnswer("31,32,33,34,35,36")));
        sampleLottos.add(factory.newInstance(inputInfo.getAnswer("40,41,42,43,44,45")));

        lottos = new Lottos(sampleLottos);
    }


    @Test
    void 당첨결과_테스트() {

        Result result = new Result(lottos, factory.newInstance(inputInfo.getAnswer("1,2,3,7,8,9")), new Bonus(10));
        Map<Rank, Integer> sampleResult = new HashMap<>();

        sampleResult.put(Rank.MISS, 0);
        sampleResult.put(Rank.FIFTH, 1);
        sampleResult.put(Rank.FOURTH, 0);
        sampleResult.put(Rank.THIRD, 0);
        sampleResult.put(Rank.SECOND, 0);
        sampleResult.put(Rank.FIRST, 0);

        // 결과 내용
        Assertions.assertThat(result.getResultInfo()).isEqualTo(sampleResult);
        // 수익금
        Assertions.assertThat(result.getRateOfReturn()).isEqualTo(1);
    }

    @Test
    void 당첨결과_2등_테스트() {
        Result result = new Result(lottos, factory.newInstance(inputInfo.getAnswer("1,2,3,7,8,9")), new Bonus(6));
        Map<Rank, Integer> sampleResult = new HashMap<>();

        sampleResult.put(Rank.MISS, 0);
        sampleResult.put(Rank.FIFTH, 0);
        sampleResult.put(Rank.FOURTH, 0);
        sampleResult.put(Rank.THIRD, 0);
        sampleResult.put(Rank.SECOND, 1);
        sampleResult.put(Rank.FIRST, 0);

        // 2등 당첨 결과 내용
        Assertions.assertThat(result.getResultInfo()).isEqualTo(sampleResult);
        // 수익금
        Assertions.assertThat(result.getRateOfReturn()).isEqualTo(6000);
    }

}
