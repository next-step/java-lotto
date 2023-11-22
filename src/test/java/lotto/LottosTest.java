package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMatchNumbers;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @DisplayName("구매 갯수를 전달하면 갯수만큼 로또를 가진 lottos 객체를 생성한다.")
    @Test
    void lottosCreateTest() {
        Lottos lottos = new Lottos(Lottos.createLottos(3));

        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @DisplayName("구매 갯수만큼 생성된 lottos 객체의 사이즈를 가져올 수 있다.")
    @Test
    void lottosSizeTest() {
        Lottos lottos = new Lottos(Lottos.createLottos(10));

        assertThat(lottos.getSize()).isEqualTo(10);
    }

    @DisplayName("인덱스를 전달하면 해당 위치의 로또를 반환한다.")
    @Test
    void getLottoTest() {
        Lottos lottos = new Lottos(Lottos.createLottos(10));
        Lotto lotto = lottos.getLotto(5);

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("당첨번호를 전달하면 당첨된 갯수 정보를 반환한다.")
    @Test
    void matchNumbersTest() {
        Lotto lotto1 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 10, 11, 12)));
        Lotto lotto3 = new Lotto(new ArrayList<>(List.of(1, 2, 3, 12, 13, 15)));
        Lottos lottos = new Lottos(new ArrayList<>(List.of(lotto1, lotto2, lotto3)));
        WinningNumbers winningNumbers = new WinningNumbers(WinningNumbers.createList("1, 2, 3, 4, 5, 6"));
        LottoMatchNumbers lottoMatchNumbers = lottos.matchNumbers(winningNumbers);
        Map<Integer, Integer> matchNumberMap = lottoMatchNumbers.getMatchNumberMap();

        assertThat(matchNumberMap.get(3)).isEqualTo(2);
        assertThat(matchNumberMap.get(4)).isEqualTo(0);
        assertThat(matchNumberMap.get(5)).isEqualTo(0);
        assertThat(matchNumberMap.get(6)).isEqualTo(1);
    }
}
