package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static lotto.domain.WinningAmount.*;

@DisplayName("로또 일급 컬렉션 테스트")
class LottosTest {

    @DisplayName("보너스 번호에 따른 로또를 확인한다.")
    @Test
    void findLottoHasBonus() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,10,11));
        Lottos lottos = new Lottos(List.of(lotto));
        List<Integer> winningNumber = List.of(1,2,3,4,5,6);

        HashMap<WinningAmount, Integer> result = lottos
                .countAllWinning(new WinningLotto(new Lotto(winningNumber), LottoNumber.valueOf(10)));

        Assertions.assertThat(result.get(FIVE_MATCH_AND_BONUS)).isEqualTo(1);
    }

    @DisplayName("로또 번호에 보너스 번호가 있는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void checkHasBonus(int bonusNumber, boolean result) {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Assertions.assertThat(lotto.hasBonus(LottoNumber.valueOf(bonusNumber))).isEqualTo(result);
    }

    @DisplayName("로또를 추가한다.")
    @Test
    void add() {
        Lotto lotto = new Lotto(new ArrayList<>(List.of(1,2,3,4,5,6)));
        Lotto otherLotto = new Lotto(new ArrayList<>(List.of(2,3,4,5,6,7)));
        List<Lotto> lottos = new ArrayList<>(Collections.singleton(lotto));
        List<Lotto> otherLottos = new ArrayList<>(Collections.singleton(otherLotto));

        lottos.addAll(otherLottos);

        Assertions.assertThat(lottos.size()).isEqualTo(2);
    }
}
