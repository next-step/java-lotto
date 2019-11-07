package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoProvider;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LottoTest {

    private WinningLotto winnerLotto;
    private List<Integer> winnerNumbers;

    @BeforeEach
    void setUp() {
        winnerNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winnerLotto = LottoProvider.createWinningLotto(winnerNumbers, 7);
    }

    @Test
    void matchLottoNumberTest() {
        assertThat(LottoProvider.createLotto(1, 2, 3, 4, 5, 6).matchTo(winnerLotto)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoProvider.createLotto(1, 2, 3, 4, 5, 7).matchTo(winnerLotto)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoProvider.createLotto(1, 2, 3, 4, 5, 40).matchTo(winnerLotto)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoProvider.createLotto(1, 2, 3, 4, 20, 40).matchTo(winnerLotto)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoProvider.createLotto(1, 2, 9, 12, 20, 40).matchTo(winnerLotto)).isEqualTo(LottoRank.NOT_MATCH);
    }

    @Test
    void invalidNumberTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).withMessage(LottoNumbers.GRATER_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5));
        }).withMessage(LottoNumbers.LESS_THAN_NUMBER_COUNT_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).withMessage(LottoNumbers.DUPLICATED_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(-1, 2, 3, 4, 5, 6));
        }).withMessage(LottoNumbers.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 46));
        }).withMessage(LottoNumbers.INVALID_RANGE_NUMBER_ERROR);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).withMessage(WinningLotto.DUPLICATED_BONUS_NUMBER_ERROR);
    }

    private class LottoArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(LottoProvider.createLotto(winnerNumbers)),
                    Arguments.of(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 5, 40))),
                    Arguments.of(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 4, 20, 40))),
                    Arguments.of(LottoProvider.createLotto(Arrays.asList(1, 2, 3, 12, 20, 40))),
                    Arguments.of(LottoProvider.createLotto(Arrays.asList(1, 2, 9, 12, 20, 40)))
            );
        }
    }
}
