package lotto.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 하나에는 번호가 6개 저장되지 않으면 Exception이 발생되어야 한다.")
    void lottoSavaNumberSizeTest() {

        // given
        List<LottoNumber> input = Arrays.asList(1, 2, 3, 4, 5)
            .stream()
            .map(LottoNumber::of)
            .collect(toList());

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(input))
            .withMessageMatching("로또 번호의 개수는 6개가 들어와야 한다.");
    }

    @Test
    @DisplayName("로또 하나에 번호가 중복되어 저장되면 Exception이 발생되어야 한다.")
    void lottoSaveDuplicatedNumberTest() {

        // given
        List<LottoNumber> input = Arrays.asList(2, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(toList());

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(input))
            .withMessageMatching("로또의 번호는 중복되어 저장될 수 없다.");
    }

    @Test
    @DisplayName("로또의 번호가 들어올 때 오름차순으로 로또에 저장된다.")
    void lottoSaveNumberAscTest() {

        // given
        List<LottoNumber> input = Arrays.asList(6, 5, 4, 3, 2, 1)
            .stream()
            .map(LottoNumber::of)
            .collect(toList());

        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(toList()));

        // when
        Lotto result = new Lotto(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("당첨 번호와 비교해서 일치하는 번호를 가져올 수 있다.")
    void lottoCalculateWinCountTest() {

        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(toList());
        Lotto lotto = new Lotto(lottoNumbers);

        List<LottoNumber> winNumbers = Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(LottoNumber::of)
            .collect(toList());
        Lotto winLotto = new Lotto(winNumbers);

        // when
        int result = lotto.calculateWinCount(winLotto);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("다른 Lotto와 동일한 number의 갯수를 반환할 수 있다.")
    void calculateWinCountTest() {

        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));

        Lotto compareLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));

        // when
        int result = lotto.calculateWinCount(compareLotto);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열로 들어온 input으로 로또를 생성할 수 있다.")
    void stringFeildConstructorTest() {

        // given
        String input = "1,2,3,4,5,6";
        Lotto expected = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(LottoNumber::of)
            .collect(Collectors.toList()));

        // when
        Lotto result = new Lotto(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

}