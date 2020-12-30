package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {

    private LottoList lottoList;

    @BeforeEach
    void setUp() {
        lottoList = new LottoList();
    }

    @Test
    void createLottoNumber() {
        lottoList.createAutoNumber(15);
        assertThat(lottoList.buyLottoCount()).isEqualTo(15);
    }
}