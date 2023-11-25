package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {
    @Test
    @DisplayName("로또 번호를 생성하는 경우 정렬되어 저장한다. - 숫자 입력 정적 팩토리 활용")
    void lottoNumberInputTest() {
        Lotto lotto = new Lotto(3, 2, 5, 11, 1, 8);

        assertThat(lotto.getLottoNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 5, 8, 11));
    }

    @Test
    @DisplayName("로또 번호를 생성하는 경우 정렬되어 저장한다. - 문자 입력 정적 팩토리 활용")
    void lottoStringInputTest() {
        Lotto lotto = new Lotto("3,2,5,11,1,8");

        assertThat(lotto.getLottoNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 5, 8, 11));
    }

    @Test
    @DisplayName("로또 번호를 생성하는 경우 정렬되어 저장한다. - 문자 입력 정적 팩토리 활용")
    void lottoListInputTest() {
        Lotto lotto = new Lotto(Arrays.asList(3, 2, 5, 11, 1, 8));

        assertThat(lotto.getLottoNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 5, 8, 11));
    }

    @Test
    @DisplayName("보너스 번호가 일치하는 경우 true return ")
    void matchBonusTest() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinningLotto winning = new WinningLotto(1, 8, 9, 10, 11, 12, 6);

        assertThat(lotto.isMatchBonusNumber(winning)).isTrue();
    }

    @Test
    @DisplayName("보너스를 포함한 winning 번호와 로또번호가 매칭되는 만큼 카운트가 증가")
    void matchLottoCountTest() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        WinningLotto winning = new WinningLotto(1, 2, 3, 10, 11, 12, 13);

        assertThat(lotto.calculateMatchCount(winning)).isEqualTo(3);
    }
    @Test
    @DisplayName("로또 숫자 갯수가 6개를 초과하는 경우 exception 발생")
    void overInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto("1, 2, 3, 4, 5, 6, 7"));
    }

    @Test
    @DisplayName("로또 중복숫자 입력되는 경우 6개 미만 exception 발생")
    void doubleInputExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lotto("1, 1, 3, 5, 6, 7"));
    }
}
