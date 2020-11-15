package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberDuplicateCheckerTest {
    private static final List<LottoNumber> notDuplicatedLottoNumbers = Arrays.asList(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
    );

    private static final List<LottoNumber> duplicatedLottoNumbers = Arrays.asList(
            LottoNumber.of(1),
            LottoNumber.of(1),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
    );

    @Test
    void hasNotDuplicates_when_receive_not_duplicated_lotto_number() {
        // when
        final boolean result = LottoNumberDuplicateChecker.hasNotDuplicates(notDuplicatedLottoNumbers);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void hasNotDuplicates_when_receive_duplicated_lotto_number() {
        // when
        final boolean result = LottoNumberDuplicateChecker.hasNotDuplicates(duplicatedLottoNumbers);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void hasDuplicates_when_receive_not_duplicated_lotto_number() {
        // when
        final boolean result = LottoNumberDuplicateChecker.hasDuplicates(notDuplicatedLottoNumbers);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void hasDuplicates_when_receive_duplicated_lotto_number() {
        // when
        final boolean result = LottoNumberDuplicateChecker.hasDuplicates(duplicatedLottoNumbers);

        // then
        assertThat(result).isTrue();
    }
}