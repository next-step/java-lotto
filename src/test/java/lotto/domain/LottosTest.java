package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    @DisplayName("생성 테스트")
    void lottos_ctor_test() {
        List<Lotto> lottos = List.of(new Lotto(List.of(new LottoNumber(1))));
        assertThatNoException().isThrownBy(() -> new Lottos(lottos));
    }

    @Test
    @DisplayName("당첨 번호 테스트")
    void winningNumber_check_test() {
        //given
        List<Lotto> lottoList = List.of(new Lotto(List.of(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        )));
        Lottos lottos = new Lottos(lottoList);
        Lotto lotto = new Lotto(List.of(
            new LottoNumber(1),
            new LottoNumber(5),
            new LottoNumber(6),
            new LottoNumber(9),
            new LottoNumber(10),
            new LottoNumber(11)
        ));

        //when
        Bank bank = lottos.checkWinningNumber(lotto);

        //then
        EnumMap<Rank, Integer> rankIntegerEnumMap = new EnumMap<>(
            Map.of(
                Rank.LOSER, 0,
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 1
            )
        );

        Assertions.assertThat(bank).isEqualTo(new Bank(rankIntegerEnumMap));
    }


}
