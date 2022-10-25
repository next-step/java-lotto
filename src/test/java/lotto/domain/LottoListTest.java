package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoListTest {

    private static final int COUNT = 3;

    @Test
    @DisplayName("지정 갯수만큼 로또가 생성되는지 확인한다.")
    void createLottoListTest() {

        //given
        LottoList lottoList = LottoList.of(COUNT);

        //then
        assertThat(lottoList.getLottoList()).hasSize(COUNT);
    }
}