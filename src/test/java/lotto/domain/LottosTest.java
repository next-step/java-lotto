package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또 만들기 테스트")
    @Test
    public void 로또만들기_테스트() {

        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        lottoList.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5,6 )));

        assertThat(Lottos.create(lottoList)).isInstanceOf(Lottos.class);
    }

    @DisplayName("로또 당첨여부 확인하기")
    @Test
    public void 로또_당첨여부_확인하기_테스트() {
        ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
        lottoList.add(Lotto.of(Arrays.asList(1, 2, 3, 4, 5,6 )));

        Lottos lottos = Lottos.create(lottoList);
        ArrayList<Integer> winningNumbers = Stream.iterate(1, n -> n + 1 )
                                                  .limit(6)
                                                  .collect(toCollection(ArrayList::new));
        lottos.checkWinningNumbers(winningNumbers);
        assertThat(lottos.lottos.get(0).rank.getMatchCount()).isEqualTo(6);
    }
}
