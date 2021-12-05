package lotto;

import lotto.domain.Lotto;
import lotto.domain.Person;
import lotto.domain.Store;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 1장은 1000원")
    @Test
    void 금액만큼_로또구매() {
        Store store = new Store();
        Person person = new Person(10000);
        List<Lotto> lottos = store.sellTo(person);
        assertThat(lottos.size()).isEqualTo(10);
    }

}
