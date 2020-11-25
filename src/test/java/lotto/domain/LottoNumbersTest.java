package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @DisplayName("로또 생성 테스트")
    @Test
    public void createLottoNumberInstance() {
        //Given & When
        List<Integer> result = LottoNumbers.getLottoNumbers();

        //Then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(6);
    }




}
