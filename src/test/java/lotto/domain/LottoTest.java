package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("랜덤 생성된 로또는 6개의 숫자로 이루어진다.")
    void createSixNumbersTest() {
        //given
        Lotto lotto = Lotto.createRandomLotto();

        //when, then
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }

    @Test
    @DisplayName("랜덤 생성된 로또는 서로 다른 숫자들로 이루어진다.")
    void distinctNumbersTest() {
        //given
        Lotto lotto = Lotto.createRandomLotto();

        //when
        List<LottoNumber> numbers = lotto.getLottoNumbers();

        //then
        assertThat(numbers.stream().distinct().count()).isEqualTo(numbers.size());
    }

    @Test
    @DisplayName("숫자를 지정하는 로또 생성 테스트")
    void createSpecificLottoTest() {
        //given
        Lotto lotto = Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6));

        //then
        assertThat(lotto.getLottoNumbers()).isEqualTo(Stream.of(1, 2, 3, 4, 5, 6)
            .map(LottoNumber::new).collect(Collectors.toList()));
    }

    @Test
    @DisplayName("중복된 숫자는 생성 불가.")
    void duplicatedNumberUnavailableTest() {

        assertThrows(IllegalArgumentException.class,
            () -> Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 5)));
    }

    @Test
    @DisplayName("수동 생성된 로또는 길이가 6이어야 한다.")
    void createSpecificSixNumbersTest() {

        assertThrows(IllegalArgumentException.class,
            () -> Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5))
        );
    }
}
