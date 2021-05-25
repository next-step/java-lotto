package autolotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {
    private final int LOTTO_NUM = 14;
    LottoList lottoList = new LottoList(LOTTO_NUM);

    @Test
    void lottoList() {
        assertThat(lottoList.lottoList().length).isEqualTo(LOTTO_NUM);
    }

}