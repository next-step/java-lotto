package lotto.domain;

import lotto.domain.exception.InvalidLottoMatchingCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoResultTest {
    private static final Lotto winningLotto = Lotto.from(new int[]{1, 2, 3, 4, 5, 6});
    private static final List<Lotto> lottoList = List.of(
            winningLotto,
            Lotto.from(new int[]{1, 2, 3, 7, 8, 9}),
            Lotto.from(new int[]{1, 2, 3, 4, 7, 8}),
            Lotto.from(new int[]{1, 2, 3, 4, 6, 45})
    );
    private static final Lottos lottos = new Lottos(lottoList);
    private static final LottoResult lottoResult = new LottoResult(lottos, winningLotto);

    @ParameterizedTest(name = "당첨 번호가 {0}개 일치하는 로또는 {1}개이다.")
    @CsvSource(value = {"3:1", "4:1", "5:1", "6:1"}, delimiter = ':')
    void 당첨_로또와_로또_여러개가_숫자_몇_개씩_일치하는지_확인할_수_있다(int input, int expected) {
        assertThat(lottoResult.getMatchingLottosCount(input)).isEqualTo(expected);
    }

    @Test
    void 당첨_결과에_대한_수익률을_알_수_있다() {
        assertThat(lottoResult.getProfitRate()).isEqualTo(500388.75);
    }

    @ParameterizedTest(name = "{0}은 잘못된 당첨 번호 갯수이므로 예외가 발생한다.")
    @ValueSource(ints = {-1, 7})
    void 잘못된_당첨_번호_갯수를_입력하면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> lottoResult.getMatchingLottosCount(input)).isInstanceOf(InvalidLottoMatchingCountException.class);
    }
}
