package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.List;

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
                .countAllWinning(new WinningLotto(new Lotto(winningNumber), 10));

        Assertions.assertThat(result.get(FIVE_MATCH_AND_BONUS)).isEqualTo(1);
    }

    @DisplayName("로또 번호에 보너스 번호가 있는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void checkHasBonus(int bonusNumber, boolean result) {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Assertions.assertThat(lotto.hasBonus(new LottoNumber(bonusNumber))).isEqualTo(result);
    }
}
