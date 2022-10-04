package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("로또 당첨 결과가 제대로 저장, 계산되는지 테스트")
    void saveResultTest2() {
        Lotto lotto = new Lotto();
        List<Lotto> lottos = Arrays.asList(lotto);
        List<Integer> collectNumberList = Arrays.stream(lotto.getNumbers()).boxed().collect(Collectors.toList());
        Result result = new Result(lottos, collectNumberList);

        assertThat(result.getWinCount(Config.LOTTE_NUMBER_COUNT)).isEqualTo(1);
        assertThat(result.getRateOfIncome()).isEqualTo(2000000);
    }

}