package lotto.step2;

import lotto.step2.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개 랜덤값을 가지고 있다.")
    void createLottoNumber() {
        Lotto lotto = new Lotto(1000);
        List<Integer> numbers =  lotto.getLottoNumber().getNumber();
        System.out.println(numbers);
        assertThat(numbers).size().isEqualTo(6);
    }

    @Test
    @DisplayName("로또 가격은 개당 1000원이다")
    void createLottoPrice() {
        Lotto lotto = new Lotto(1000);
        int price = lotto.getLottoPrice().getPrice();
        assertThat(price).isEqualTo(1000);
    }

}