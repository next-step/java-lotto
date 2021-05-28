package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.BonusNumber;
import step3.domain.Lotto;
import step3.exception.DuplicatedNumberException;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {


    @Test
    @DisplayName("이번 주 로또와 보너스 넘버가 중복 되는 경우 에러가 나는 테스트")
    void duplicatedWithWinningLotto() {
        assertThatThrownBy(() -> new BonusNumber(new Lotto(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))), 3))
                .isInstanceOf(DuplicatedNumberException.class)
                .hasMessageContaining(DuplicatedNumberException.MESSAGE);
    }

    @Test
    @DisplayName("구매한 로또와 보너스 넘버가 일치 하는 경우 성공 테스트")
    void isMatchedTest() {
        Lotto winningLotto = new Lotto(new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto boughtLotto = new Lotto(new TreeSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        BonusNumber bonusNumber = new BonusNumber(winningLotto, 7);

        assertThat(bonusNumber.isMatchedWithLotto(boughtLotto));
    }
}