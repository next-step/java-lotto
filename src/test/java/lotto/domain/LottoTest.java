package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {


    @DisplayName("saving Lotto Number test")
    @Test
    void 로또_번호_저장() {
        int [] lottoNumbers = {1,2,3,4,5,6};
        List<LottoNumber> numbers = LottoFactory.createListOfLottoNumber(lottoNumbers);
        Lotto playersLotto = new Lotto(numbers);
        Assertions.assertThat(playersLotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("incompatible count of Lotto number test")
    @Test
    void lottoNumCountNotQualified() {
        int [] lottoNumbersWithShortLength = {1,2,3,4,5};
        Assertions.assertThatThrownBy(() -> {
            List<LottoNumber> numbers = LottoFactory.createListOfLottoNumber(lottoNumbersWithShortLength);
            Lotto playersLotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("duplicated lotto number in one ticket test")
    @Test
    void duplicatedLottoNum() {
        int [] duplicatedLottoNumbers = {2,2,2,3,4,5};

        Assertions.assertThatThrownBy(() -> {
            List<LottoNumber> numbers = LottoFactory.createListOfLottoNumber(duplicatedLottoNumbers);
            Lotto playersLotto = new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}