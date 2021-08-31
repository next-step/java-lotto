package lotto.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("로또 하나에는 번호가 6개 저장되지 않으면 Exception이 발생되어야 한다.")
    void lottoSavaNumberSizeTest() {

        // given
        List<Number> input = Arrays.asList(1, 2, 3, 4, 5)
            .stream()
            .map(Number::new)
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
        List<Number> input = Arrays.asList(2, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(toList());

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(input))
            .withMessageMatching("로또의 번호는 중복되어 저장될 수 없다.");
    }

    @Test
    @DisplayName("로또 번호에 1이상 45이하의 수가 들어오지 않으면 Exception이 발생되어야 한다.")
    void lottoSaveNumberRangeTest() {

        // given
        List<Number> input = Arrays.asList(1, 2, 3, 4, 5, 76)
            .stream()
            .map(Number::new)
            .collect(toList());

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(input))
            .withMessageMatching("로또 번호는 1이상 45이하의 수만 들어올 수 있다.");
    }

    @Test
    @DisplayName("로또의 번호가 오름차순으로 입력되지 않으면 Exception이 발생되어야 한다.")
    void lottoSaveNumberAscTest() {

        // given
        List<Number> input = Arrays.asList(1, 2, 3, 4, 6, 5)
            .stream()
            .map(Number::new)
            .collect(toList());

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Lotto(input))
            .withMessageMatching("로또 번호는 오름차순으로 입력되어있어야 한다.");
    }

    @Test
    @DisplayName("당첨 번호와 비교해서 일치하는 번호를 가져올 수 있다.")
    void lottoCalculateWinCountTest() {

        // given
        List<Number> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6)
            .stream()
            .map(Number::new)
            .collect(toList());
        Lotto lotto = new Lotto(lottoNumbers);

        List<Number> winNumbers = Arrays.asList(4, 5, 6, 7, 8, 9)
            .stream()
            .map(Number::new)
            .collect(toList());
        Lotto winLotto = new Lotto(winNumbers);

        // when
        int result = lotto.calculateWinCount(winLotto);

        // then
        assertThat(result).isEqualTo(3);
    }

}