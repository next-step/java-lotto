package lottoauto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lottoauto.LottoFixture;
import lottoauto.model.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또생성_및_리턴_테스트() {
        Integer[] integer = {3, 4, 5, 6, 7, 8};
        Lotto lotto = LottoFixture.lottoFixture(integer);
        List<LottoNumber> lottoNumber = Arrays.stream(integer).map(LottoNumber::from).collect(Collectors.toList());

        Assertions.assertThat(lotto.getNumbers()).isEqualTo(lottoNumber);
    }

    @Test
    void 로또생성_실패_테스트_개수_부족() {
        Integer integer = 3;

        Assertions.assertThatThrownBy(() -> LottoFixture.lottosFixture(integer))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또의 숫자가 6개가 아닙니다.");
    }

    @Test
    void 로또생성_실패_테스트_숫자_중복() {
        Integer[] integer = {3, 4, 5, 6, 6, 7};

        Assertions.assertThatThrownBy(() -> LottoFixture.lottosFixture(integer))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("중복되는 숫자가 있습니다.");
    }


    @Test
    void lottos_생성_및_출력테스트() {
        Integer[] integer = {3, 4, 6, 7, 8, 9};
        Lotto lotto = LottoFixture.lottoFixture(integer);
        Lottos lottos = LottoFixture.lottosFixture(lotto);

        Assertions.assertThat(lottos.getLottos().get(0)).isEqualTo(lotto);
        Assertions.assertThat(lottos.getSize()).isEqualTo(1);
    }

    @Test
    void lottoResult_수익률_테스트() {
        int buyPrice = 10000;
        WinningReward winningReward = WinningReward.MATCH_3;
        List<WinningReward> result = List.of(winningReward);

        int count = Collections.frequency(result, winningReward);
        LottoResult lottoResult = new LottoResult(result);

        Assertions.assertThat(lottoResult.getMatchCount().get(0)).isEqualTo(result.get(0));
        Assertions.assertThat(lottoResult.getRate(buyPrice))
                .isEqualTo(Math.round((count * (double) winningReward.getReward() / buyPrice) / 100));
    }
}
