package Lotto.service;

import Lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningServiceTest {

    @DisplayName("로또의 당첨 개수 확인")
    @ParameterizedTest
    @MethodSource("generateData")
    void lotto_match(Lotto lotto, int count){
        //given
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));

        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, 1);

        //when
        int matchCount = lottoWinningService.compareLotto(lotto);

        //then
        assertThat(matchCount).isEqualTo(count);
    }

    @DisplayName("보너스의 당첨 여부 확인 - 성공")
    @Test
    void lotto_match(){
        //given
        int bonus = 7;
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));
        Lotto lotto = new Lotto(List.of(1,3,6,15,32,bonus));

        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, bonus);

        //when
        boolean matchBonus = lottoWinningService.compareLottoBonus(lotto);

        //then
        assertThat(matchBonus).isTrue();
    }

    @DisplayName("보너스의 당첨 여부 확인 - 실패")
    @Test
    void lotto_not_match(){
        //given
        int bonus = 7;
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));
        Lotto lotto = new Lotto(List.of(1,3,6,15,32,8));

        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, bonus);

        //when
        boolean matchBonus = lottoWinningService.compareLottoBonus(lotto);

        //then
        assertThat(matchBonus).isFalse();
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,3,6,9,23,17)), 3),
                Arguments.of(new Lotto(List.of(1,3,6,15,23,17)), 4),
                Arguments.of(new Lotto(List.of(1,3,6,15,32,17)), 5)
        );
    }
}