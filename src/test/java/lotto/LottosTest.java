package lotto;

import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinnerLotto;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;

import static lotto.LottoNumberTest.*;
import static lotto.LottoTest.TEST_LOTTO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 리스트를 담는 Lottos 클래스 테스트")
public class LottosTest {

    private static final Lottos TEST_LOTTOS = new Lottos(Lists.newArrayList(TEST_LOTTO));

    @ParameterizedTest
    @NullSource
    @DisplayName("Lottos 생성시 인자로 null이 들어오면 NullPointerException이 발생한다.")
    void nullTest(List<Lotto> lottos) {
        assertThatThrownBy(() -> new Lottos(lottos))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("size() 메서드로 로또들의 개수를 구할 수 있다.")
    void sizeTest() {
        assertThat(TEST_LOTTOS.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 로또를 입력해 결과를 계산할 때 입력값이 null이면 예외가 발생한다.")
    void getLottoResultNullTest() {
        assertThatThrownBy(() -> TEST_LOTTOS.extractLottoResult(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또를 입력하면 통계 결과를 얻을 수 있다.")
    void getLottoResultTest() {
        // given
        Lotto winnerLotto = new Lotto(ExtractLottoNumbersTest.LOTTO_NUMBERS);
        Lotto buyingLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, LottoNumber.valueOf(10)));

        // when
        LottoResult lottoResult = new Lottos(Lists.newArrayList(buyingLotto)).extractLottoResult(new WinnerLotto(winnerLotto, LottoNumber.valueOf(10)));

        // then
        assertThat(lottoResult.getRankResult().get(0)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또를 입력하면 통계 결과를 얻을 수 있다. 없는 값은 0으로 초기화된다")
    void getLottoResultDefaultTest() {
        // given
        Lotto winnerLotto = new Lotto(ExtractLottoNumbersTest.LOTTO_NUMBERS);
        Lotto twoMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, LottoNumber.valueOf(9), LottoNumber.valueOf(10), LottoNumber.valueOf(11), LottoNumber.valueOf(12)));

        // when
        LottoResult lottoResult = new Lottos(Lists.newArrayList(twoMatchLotto)).extractLottoResult(new WinnerLotto(winnerLotto, LottoNumber.valueOf(15)));

        // then
        assertThat(lottoResult.getRankResult().get(0)).isEqualTo(Rank.OTHER);
    }

    @Test
    @DisplayName("기준 리스트와 generator로 생성할 count를 입력받으면 하나의 Lottos 객체가 생성된다.")
    void makeWithBaseAndCountTest() {
        Lottos lottos = Lottos.makeWithBaseAndCount(Lists.newArrayList(TEST_LOTTO), 1L);

        assertThat(lottos.size()).isEqualTo(2);
    }
}
