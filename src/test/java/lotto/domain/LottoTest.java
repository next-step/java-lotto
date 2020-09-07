package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("lotto 생성 테스트")
    @Test
    public void 로또_생성테스트(){
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                                              .limit(6)
                                              .collect(toCollection(ArrayList::new));
        assertThat(Lotto.of(lottoNums)).isInstanceOf(Lotto.class);
    }

    @DisplayName("lotto 생성 테스트 - 음수 값 주어져있을때")
    @Test
    public void 로또_생성테스트_숫자확인(){
        ArrayList<Integer> lottoNums = Stream.iterate(1, n -> n + 1 )
                                             .limit(6)
                                             .collect(toCollection(ArrayList::new));

        assertThatThrownBy(
                () -> Lotto.of(lottoNums)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("lotto 생성 테스트 - 45 초과값 주어졌을대")
    @Test
    public void 로또_생성테스트_숫자확인_45초과(){
        ArrayList<Integer> lottoNums = Stream.iterate(45, n -> n + 1 )
                .limit(6)
                .collect(toCollection(ArrayList::new));

        assertThatThrownBy(
                () -> Lotto.of(lottoNums)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
