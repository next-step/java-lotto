package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {
    private static final Lotto lotto = Lotto.from(Set.of(1, 2, 3, 4, 5, 6));
    private static final LottoNumber bonusNumber = new LottoNumber(45);
    private static final List<Lotto> lottoList = List.of(
            lotto,
            Lotto.from(Set.of(1, 2, 3, 7, 8, 9)),
            Lotto.from(Set.of(1, 2, 3, 4, 7, 8)),
            Lotto.from(Set.of(1, 2, 3, 4, 6, 45))
    );
    private static final Lottos lottos = new Lottos(lottoList);
    private static final WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
    private static final LottoResult lottoResult = new LottoResult(lottos, winningLotto);

    @ParameterizedTest(name = "당첨 번호가 {0}개 일치하는 로또는 {1}개이다.")
    @MethodSource("getInputFor_당첨된_로또가_몇_장인지_확인할_수_있다")
    void 당첨된_로또가_몇_장인지_확인할_수_있다(LottoPrize input, int expected) {
        assertThat(lottoResult.getMatchingLottosCount(input)).isEqualTo(expected);
    }

    @Test
    void 당첨_결과에_대한_수익률을_알_수_있다() {
        assertThat(lottoResult.getProfitRate()).isEqualTo(507513.75);
    }

    private static Stream<Arguments> getInputFor_당첨된_로또가_몇_장인지_확인할_수_있다() {
        return Stream.of(
                Arguments.arguments(LottoPrize.FIFTH, 1),
                Arguments.arguments(LottoPrize.FOURTH, 1),
                Arguments.arguments(LottoPrize.THIRD, 0),
                Arguments.arguments(LottoPrize.SECOND, 1),
                Arguments.arguments(LottoPrize.FIRST, 1)
        );
    }
}
