package lotto;

import lotto.domain.*;
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

    @Test
    void matchNumberText() {
        Lotto lotto = LottoProvider.createLotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(1, 2, 3, 4, 5, 6))).isEqualTo(6);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(1, 2, 3, 4, 5, 7))).isEqualTo(5);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(1, 2, 3, 4, 7, 8))).isEqualTo(4);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(1, 2, 3, 7, 8, 9))).isEqualTo(3);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(1, 2, 7, 8, 9, 10))).isEqualTo(2);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(1, 7, 8, 9, 10, 11))).isEqualTo(1);
        assertThat(lotto.getMatchNumberCount(LottoProvider.createLotto(7, 8, 9, 10, 11, 12))).isEqualTo(0);
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
}
