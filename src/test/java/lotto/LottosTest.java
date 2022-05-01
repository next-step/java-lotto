package lotto;

import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Rank;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.Map;

import static lotto.LottoNumberTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Lotto 리스트를 담는 Lottos 클래스 테스트")
public class LottosTest {

    private static final Lottos TEST_LOTTOS = new Lottos(Lists.newArrayList(LottoTest.TEST_LOTTO));

    @ParameterizedTest
    @NullSource
    @DisplayName("Lottos 생성시 인자로 null이 들어오면 NullPointerException이 발생한다.")
    void nullTest(List<Lotto> lottos) {
        assertThatThrownBy(() -> new Lottos(lottos))
                .isInstanceOf(NullPointerException.class);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("Lottos 생성시 인자로 빈 리스트가 들어오면 예외가 발생한다.")
    void emptyTest(List<Lotto> lottos) {
        assertThatThrownBy(() -> new Lottos(lottos))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("size() 메서드로 로또들의 개수를 구할 수 있다.")
    void sizeTest() {
        assertThat(TEST_LOTTOS.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 로또를 입력해 결과를 계산할 때 입력값이 null이면 예외가 발생한다.")
    void getLottoResultNullTest() {
        assertThatThrownBy(() -> TEST_LOTTOS.getLottoResult(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또를 입력하면 통계 결과를 얻을 수 있다.")
    void getLottoResultTest() {
        LottoNumber ten = new LottoNumber(10);
        LottoNumber eleven = new LottoNumber(11);
        LottoNumber twelve = new LottoNumber(12);
        // given
        Lotto winnerLotto = new Lotto(ExtractLottoNumbersTest.LOTTO_NUMBERS);
        Lotto threeMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, ten, eleven, twelve));
        Lotto fourMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, eleven, twelve));
        Lotto fiveMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, twelve));
        Lotto sixMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, SIX));

        // when
        LottoResult lottoResult = new Lottos(Lists.newArrayList(threeMatchLotto, fourMatchLotto, fiveMatchLotto, sixMatchLotto)).getLottoResult(winnerLotto);

        // then
        assertThat(lottoResult.getRankResult().get(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getRankResult().get(Rank.THIRD)).isEqualTo(1);
        assertThat(lottoResult.getRankResult().get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또를 입력하면 통계 결과를 얻을 수 있다. 없는 값은 0으로 초기화된다")
    void getLottoResultDefaultTest() {
        LottoNumber ten = new LottoNumber(10);
        LottoNumber eleven = new LottoNumber(11);
        LottoNumber twelve = new LottoNumber(12);
        // given
        Lotto winnerLotto = new Lotto(ExtractLottoNumbersTest.LOTTO_NUMBERS);
        Lotto threeMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, ten, eleven, twelve));
        Lotto threeMatchLotto1 = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, ten, eleven, twelve));
        Lotto fiveMatchLotto = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, twelve));

        // when
        LottoResult lottoResult = new Lottos(Lists.newArrayList(threeMatchLotto, threeMatchLotto1, fiveMatchLotto)).getLottoResult(winnerLotto);

        // then
        assertThat(lottoResult.getRankResult().get(Rank.FIRST)).isEqualTo(0);
        assertThat(lottoResult.getRankResult().get(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getRankResult().get(Rank.THIRD)).isEqualTo(0);
        assertThat(lottoResult.getRankResult().get(Rank.FOURTH)).isEqualTo(2);
        assertThat(lottoResult.getRankResult().get(Rank.OTHER)).isEqualTo(null);
    }
}
