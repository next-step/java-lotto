package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("주어진 금액만큼 구매 가능한 개수의 Lotto를 생성하여 리스트에 추가한다.")
    void 로또구매() {
        Lottos lottos = new Lottos(LottoPurchaseAmount.of(10000));
        assertThat(lottos.count()).isEqualTo(10);
    }

    @Test
    @DisplayName("랜덤으로 생성된 로또의 개수를 알려준다.")
    void 랜덤로또_개수() {
        List<List<LottoNumber>> inNumbersList = new ArrayList();
        inNumbersList.add(convertToNumberList(new ArrayList<>(Arrays.asList(20,40,30,10,5,25))));
        Lottos lottos = new Lottos(LottoPurchaseAmount.of(10000), inNumbersList);
        assertThat(lottos.getRandomLottoCount()).isEqualTo(9);
    }

    List<LottoNumber> convertToNumberList(List<Integer> inNumbers) {
        return inNumbers.stream()
                .map(num -> new LottoNumber(num))
                .collect(Collectors.toList());
    }
}
