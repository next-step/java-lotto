package lotto_auto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumbersManagerTest {


    @DisplayName("로또 번호 생성 테스트")
    @Test
    public void createLottoNumberTest() {
        LottoNumbers lottoNumbers = LottoNumberManager.generate();


        List<Integer> lottoNumberList = lottoNumbers.export();

        assertAll(
                () -> assertThat(lottoNumbers).isNotNull(),
                () -> assertThat(lottoNumberList).isNotNull(),
                () -> assertThat(lottoNumberList.size()).isEqualTo(6)
        );
    }
}
