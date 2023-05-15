package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("구매한 개수만큼 로또를 발급한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100})
    public void issueLottoTest(int purchaseAmount) {
        assertThat(new Lottos(purchaseAmount, new SimpleNumberGenerator()).getAmount()).isEqualTo(purchaseAmount);
    }

    @DisplayName("로또 결과에 맞는 결과값을 반환한다.")
    @Test
    public void getResultTest() {
        List<step3.domain.Lotto> lottoList = new ArrayList<>();
        lottoList.add(new step3.domain.Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        Lottos lottos = new Lottos(lottoList);

        Map<Integer, Integer> lottosResult = lottos.getResult(List.of(4, 5, 6, 7, 8, 9));

        assertThat(lottosResult.get(0)).isEqualTo(0);
        assertThat(lottosResult.get(1)).isEqualTo(0);
        assertThat(lottosResult.get(2)).isEqualTo(0);
        assertThat(lottosResult.get(3)).isEqualTo(1);
        assertThat(lottosResult.get(4)).isEqualTo(1);
        assertThat(lottosResult.get(5)).isEqualTo(0);
        assertThat(lottosResult.get(6)).isEqualTo(0);
    }
}
