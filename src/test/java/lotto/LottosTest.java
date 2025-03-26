package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoListTest {
    @DisplayName("로또 리스트 (로또 여러 개) 생성 테스트")
    @Test
    void create_lotto_list () {
        LottoList lottoList = new LottoList(2,
                Arrays.asList(
                        new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)),
                        new Lotto(Arrays.asList(35, 23, 5, 9, 3, 8))
                )
        );
        assertThat(lottoList)
                .extracting("lottoList")
                .asList()
                .hasSize(2);

        assertThat(lottoList)
                .extracting("lottoList")
                .asList()
                .containsExactly(
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(3, 5, 8, 9, 23, 35))
                );

    }


}
