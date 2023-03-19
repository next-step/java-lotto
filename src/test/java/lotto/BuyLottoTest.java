package lotto;

import lotto.service.BuyLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

class BuyLottoTest {

    @Test
    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 발급한다.")
    void 로도_구입_금액() {
        Set<Integer> lotto = new HashSet<>();

        lotto.add(3);
        lotto.add(16);
        lotto.add(2);
        lotto.add(44);
        lotto.add(33);
        lotto.add(18);

        BuyLotto buyLotto = new BuyLotto(3000);

        Assertions.assertThat(buyLotto.getCount()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {4453, 0, -1000, 5003})
    @DisplayName("1,000원 단위로 입력하지 않은 경우 오류체크를 확인한다.")
    void 로또_구입_금액_1000원_단위_오류체크(int amt) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> {new BuyLotto(amt);});
    }


    @Test
    void 숫자_테스트() {
        long num1 = 10000;
        long num2 = 34567;

        float ratio = (float) (num2 - num1) / num1;
        float ratio1 = ((float) (num2 - num1) / num1) * 100;
        float ratio2 = (Math.round(
                ((float) (num2 - num1) / num1) * 100
        ))/100;

        float ratio3 = (ratio2/100);

        System.out.println(ratio);
        System.out.println(ratio1);
        System.out.println(ratio2);
        System.out.println(ratio3);
    }
}