package lotto.domain;

import lotto.domain.value.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createTest() {
        List<LottoNumber> test = Arrays.asList(LottoNumber.from(1),LottoNumber.from(2),LottoNumber.from(3)
                ,LottoNumber.from(4),LottoNumber.from(5),LottoNumber.from(6));
        Lotto lotto = Lotto.from(test);

        assertThat(lotto).isEqualTo(Lotto.from(test));
    }

    @Test
    @DisplayName("1~45 랜덤 함수 생성 기능")
    void randomCreateTest() {
        Lotto autoLotto = new Lotto();
        List<LottoNumber> lottoRandomNumbers = autoLotto.getNumbers();

        assertThat(lottoRandomNumbers).size().isEqualTo(6);
    }

    @Test
    @DisplayName("예외 검증")
    void exceptionTest() {
        assertThatThrownBy(() -> Lotto.from(Arrays.asList(LottoNumber.from(1),LottoNumber.from(2),
                LottoNumber.from(3),LottoNumber.from(4),LottoNumber.from(5)
                ,LottoNumber.from(6),LottoNumber.from(7))))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lotto.from(Arrays.asList(LottoNumber.from(1),
                LottoNumber.from(2),LottoNumber.from(3))))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("맞은 개수 카운트 검증")
    void checkCount() {
        List<Integer> winningNumber = Arrays.asList(1,2,3,4,5,6);

        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.from(1),LottoNumber.from(2),LottoNumber.from(3),
                LottoNumber.from(4),LottoNumber.from(5),LottoNumber.from(10)
        );

        Lotto winning = Lotto.winningFrom(winningNumber);
        Lotto auto = Lotto.from(lottoNumbers);

        assertThat(auto.countOfMatch(winning, 5)).isTrue();
    }

}
