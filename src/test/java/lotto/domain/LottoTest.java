package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("set의 갯수가 6개 미만일때는 생성되지 않는다.")
    void createLottoTest() {

        //given
        Set<Integer> item = Sets.set(1, 2, 3, 4, 5);
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.from(item));
    }

    @Test
    @DisplayName("로또 번호 비교 테스트")
    void compareTest() {

        //given
        Set<Integer> item = Sets.set(1, 2, 3, 4, 5, 6);
        Set<LottoNumber> item1 = IntStream.rangeClosed(7, 12)
            .mapToObj(LottoNumber::from).collect(
                Collectors.toSet());
        Lotto lotto = Lotto.from(item);
        int compareCount = 0;

        //when
        int compare = lotto.compare(item1);
        //when
        assertThat(compare).isEqualTo(compareCount);
    }

    @Test
    @DisplayName("set의 이미 등록된 숫자로 bonusNumber 가 추가되지 않는다")
    void setNotBonusLottoTest() {

        //given
        Set<Integer> item = Sets.set(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(item);
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> lotto.setBonusItem(6));
    }
}