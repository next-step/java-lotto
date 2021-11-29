package lotto.domain;

import lotto.domain.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 인위적으로 생성 테스트")
    void createTest() {
        List<LottoNumber> test = Arrays.asList(new LottoNumber(1),new LottoNumber(2),new LottoNumber(3)
                ,new LottoNumber(4),new LottoNumber(5),new LottoNumber(6));
        Lotto lotto = Lotto.from(test);

        assertThat(lotto).isEqualTo(Lotto.from(test));
    }

    @Test
    @DisplayName("로또객체 자동으로 생성 되는지 테스트")
    void randomCreateTest() {
        Lotto autoLotto = new Lotto();
        Set<LottoNumber> lottoRandomNumbers = autoLotto.getNumbers();

        assertThat(lottoRandomNumbers).size().isEqualTo(6);
    }

    @Test
    @DisplayName("객체 생성 시 사이즈가 6넘어가는지 예외 검증")
    void exceptionTest() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(new LottoNumber(1),new LottoNumber(2),
                new LottoNumber(3),new LottoNumber(4),new LottoNumber(5)
                ,new LottoNumber(6),new LottoNumber(7))))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),new LottoNumber(3))))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("몇 개의 번호가 맞는지 개수 카운트 검증")
    void checkCount() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);

        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),new LottoNumber(2),new LottoNumber(3),
                new LottoNumber(4),new LottoNumber(11),new LottoNumber(10)
        );

        Lotto winning = Lotto.winningFrom(winningNumber);
        Lotto auto = Lotto.from(lottoNumbers);

        assertThat(auto.isCountOfMatch(winning, 4)).isTrue();
    }

}
