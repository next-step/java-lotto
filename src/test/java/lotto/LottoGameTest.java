package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoGameTest {
    @DisplayName("번호를 자동으로 생성한다.")
    @Test
    public void makeNumber() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.makeNumbers();

        assertThat(lottoGame.getNumbers()).isNotNull();
    }

    @DisplayName("당첨 번호 숫자와 로또 게임 숫자를 비교하여 맞은 갯수를 반환한다.")
    @Test
    public void count() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 19, 29, 33);
        List<Integer> winNumbers = Arrays.asList(1, 3, 5, 19, 29, 45);

        LottoGame lottoGame = new LottoGame(new Numbers(numbers));
        HitResult hitResult = lottoGame.lotto(new WinNumbers(winNumbers));

        assertThat(hitResult.hitCount()).isEqualTo(new HitCount(5));
    }

    @DisplayName("당첨 번호 숫자와 로또 게임 숫자를 비교하여 당첨 금액을 반환한다.")
    @Test
    public void money() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 19, 29, 33);
        List<Integer> winNumbers = Arrays.asList(1, 3, 5, 19, 29, 45);

        LottoGame lottoGame = new LottoGame(new Numbers(numbers));
        HitResult hitResult = lottoGame.lotto(new WinNumbers(winNumbers));

        assertThat(hitResult.hitMoney()).isEqualTo(new HitMoney(1_500_000));
    }
}
