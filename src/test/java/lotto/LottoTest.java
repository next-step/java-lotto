package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 1장은 1000원")
    @Test
    void 금액만큼_로또구매() {
        Store store = new Store();
        Person person = new Person(10000);
        store.sellTo(person);
        assertThat(person.numberOfLotto()).isEqualTo(10);
    }

    @DisplayName("당첨번호와 로또번호는 몇 개 일치하는지 확인")
    @Test
    void 당첨번호와_로또번호_일치하는숫자() {
        Lotto lotto = new Lotto(LottoNumber.of(Arrays.asList(3, 4, 10, 45, 12, 11)));
        List<Integer> winningNumbers = Arrays.asList(2, 10, 42, 45, 18, 11);

        assertThat(lotto.matchedCount(winningNumbers)).isEqualTo(3);
    }

    @Test
    void 수익률() {
        Lotto lotto = new Lotto(LottoNumber.of(Arrays.asList(3, 4, 10, 45, 12, 11)));

    }

}
