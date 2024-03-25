package lotto;

import lotto.domain.LottoList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoListTest {

    @Test
    @DisplayName("생성자로 넘겨준 정수값 수만큼 lotto 개수를 가지고 있다")
    void createLottoList(){
        LottoList lottoList = new LottoList(5);
        Assertions.assertThat(lottoList.size()).isEqualTo(new LottoList(5).size());
    }

}