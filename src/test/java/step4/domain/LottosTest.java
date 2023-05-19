package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.*;

import java.util.ArrayList;
import java.util.List;

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
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottoList.add(new Lotto(List.of(4, 5, 6, 7, 10, 45)));
        Lottos lottos = new Lottos(lottoList);

        LottosTotalResult lottosResult = lottos.getResult(List.of(4, 5, 6, 7, 8, 9), 45);

        assertThat(lottosResult.get(Rank.MISS)).isEqualTo(0);
        assertThat(lottosResult.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(lottosResult.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottosResult.get(Rank.THIRD)).isEqualTo(0);
        assertThat(lottosResult.get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottosResult.get(Rank.FIRST)).isEqualTo(0);
    }
}
