package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @DisplayName("LottoNumbers 인스턴스 생성 테스트")
    @Test
    public void createLottoNumberInstance() {
        //Given & When
        LottoNumbers lottoNumbers = new LottoNumbers(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8)));

        //Then
        assertThat(lottoNumbers).isNotNull();
    }




}
