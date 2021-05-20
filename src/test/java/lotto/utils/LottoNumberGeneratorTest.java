package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberGeneratorTest {

    @DisplayName("입력받은 문자열 번호를 정수형 리스트로 생성 확인")
    @Test
    public void createLottoNumbers() {
        List<String> inputLottoNumbers = Arrays.asList("1","2","3","4","5","6");

        List<Integer> lottoNumbers = LottoNumberGenerator.manualGenerator(inputLottoNumbers);

        assertThat(lottoNumbers).containsExactly(1,2,3,4,5,6);
    }

    @DisplayName("자동 로또번호의 생성확인")
    @Test
    public void createAutoGenerator() {
        List<Integer> lottoNumbers = LottoNumberGenerator.autoGenerator();

        assertThat(lottoNumbers).hasSize(6);
    }

}
