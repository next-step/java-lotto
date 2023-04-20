package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("Lotto 추첨 대상 번호 생성")
    void lottoNumbersTest() {
        assertThat(Lotto.LOTTO_NUMBERS)
                .hasSize(45);
    }

    @Test
    @DisplayName("Lotto 발급")
    void publishLottoTest() {
        Lotto lotto = Lotto.initLotto();
        assertThat(lotto.getLottoSize())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto 셔플 테스트")
    void lottoShuffleTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));
        List<Integer> lottoNumbers2 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));

        Collections.shuffle(lottoNumbers1);

        assertThat(new Lotto(lottoNumbers1))
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(lottoNumbers2));
    }

    @Test
    @DisplayName("Lotto 정렬 테스트")
    void lottoSortTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));
        List<Integer> lottoNumbers2 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));

        Collections.sort(lottoNumbers2);

        assertThat(new Lotto(lottoNumbers1))
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(lottoNumbers2));
    }

}