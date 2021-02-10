package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {


    @DisplayName("saving Lotto Number test")
    @Test
    void 로또_번호_저장() {
        List<Integer> LottoNumbers = Arrays.asList(1,2,3,4,5,6);
        List<LottoNumber> expectedLottoNumbers = LottoNumbers.stream().map(LottoNumber::of).collect(Collectors.toList());
        Lotto playersLotto = LottoFactory.createLotto(LottoNumbers);
        Assertions.assertThat(playersLotto.getNumbers()).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("incompatible count of Lotto number test")
    @Test
    void lottoNumCountNotQualified() {
        List<Integer> lottoNumbersWithShortLength = Arrays.asList(1,2,3,4,5);
        Assertions.assertThatThrownBy(() -> {
            Lotto playersLotto = LottoFactory.createLotto(lottoNumbersWithShortLength);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("duplicated lotto number in one ticket test")
    @Test
    void duplicatedLottoNum() {
        List<Integer> duplicatedLottoNumbers = Arrays.asList(2,2,2,3,4,5);

        Assertions.assertThatThrownBy(() -> {
            Lotto playersLotto = LottoFactory.createLotto(duplicatedLottoNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}