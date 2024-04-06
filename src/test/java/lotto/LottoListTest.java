package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoListTest {

    @Test
    @DisplayName("생성자로 넘겨준 정수값 수만큼 lotto 개수를 가지고 있다")
    void createLottoList(){
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        LottoList lottoList = new LottoList(List.of(lotto));
        List<String> expected = List.of(List.of("1, 2, 3, 4, 5, 6").toString());
        Assertions.assertThat(lottoList.getLottoTextList()).isEqualTo(expected);
    }
}