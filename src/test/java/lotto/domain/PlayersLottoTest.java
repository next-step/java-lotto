package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PlayersLottoTest {


    @DisplayName("로또 번호 저장 테스치")
    @Test
    void 로또_번호_저장() {
        int [] lottoNumbers = {1,2,3,4,5,6};
        List<LottoNumber> numbers = LottoFactory.createListOfLottoNumber(lottoNumbers);
        PlayersLotto playersLotto = new PlayersLotto(numbers);
        Assertions.assertThat(playersLotto.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 번호 갯수의 불일치")
    @Test
    void lottoNumCountNotQualified() {
        int [] lottoNumbersWithShortLength = {1,2,3,4,5};
        Assertions.assertThatThrownBy(() -> {
            List<LottoNumber> numbers = LottoFactory.createListOfLottoNumber(lottoNumbersWithShortLength);
            PlayersLotto playersLotto = new PlayersLotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("중복된 번호의 포함")
    @Test
    void duplicatedLottoNum() {
        int [] duplicatedLottoNumbers = {2,2,2,3,4,5};

        Assertions.assertThatThrownBy(() -> {
            List<LottoNumber> numbers = LottoFactory.createListOfLottoNumber(duplicatedLottoNumbers);
            PlayersLotto playersLotto = new PlayersLotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}