package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.LottoManager;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"
    }, delimiter = '@')
    @DisplayName("문자열 입력으로 로또 생성")
    void create(String input) {
        new Lotto(input);
    }

    @ParameterizedTest
    @DisplayName("잘못된 문자열 입력으로 로또 생성 실패")
    @CsvSource(value = {
            "1", "1, 2, 3, 5", "1, 1, 1, 1, 1, 1", "1, 2, 3, 4, 5, 6, 7", "-, 2, 3, 4, 5, 6"
    }, delimiter = '@')
    void createFail(String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호로 로또 생성")
    void createByNumbers() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.allLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        new Lotto(allLottoNumbers.stream()
            .limit(Lotto.needLottoNumberCount.value())
            .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("잘못된 개수의 로또 번호로 로또 생성")
    void createByNumbersFail() {
        final List<LottoNumber> allLottoNumbers = LottoNumber.allLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        Assertions.assertThatThrownBy(() -> new Lotto(allLottoNumbers.stream()
            .limit(Lotto.needLottoNumberCount.value() + 1)
            .collect(Collectors.toList())))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("같은 로또 번호로 포함 여부를 검증할 수 있음")
    void contains() {
        final Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        Assertions.assertThat(lotto.contains(new LottoNumber("1"))).isTrue();
        Assertions.assertThat(lotto.contains(new LottoNumber("7"))).isFalse();
    }

    @Test
    @DisplayName("서로 다른 로또끼리 비교하여 일치하는 번호의 개수를 반환")
    void match() {
        final Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        final Lotto other = new Lotto("1, 2, 3, 4, 5, 7");

        Assertions.assertThat(lotto.matchCount(other)).isEqualTo(5);
    }
}