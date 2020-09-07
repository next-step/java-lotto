package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LottoStoreTest {
    LottoStore lottoStore;

    @BeforeEach
    void create() {
        List<String> list = new ArrayList<String>();
        list.add("10, 20, 30, 40, 41, 45");
        list.add("11, 22, 33, 40, 41, 45");
        lottoStore = new LottoStore(list, 2);
    }

    @Test
    @DisplayName("객체 생성")
    void createLottoStore() {
        Assertions.assertThat(lottoStore.getManuaCount()).isEqualTo(2);
        Assertions.assertThat(lottoStore.getAutoCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("LottoPapers 객체 생성 확인")
    void makeLottoPapers() {
        Assertions.assertThat(lottoStore.makeLottoPapers().getPapersSize())
                .isEqualTo(2);
    }
}