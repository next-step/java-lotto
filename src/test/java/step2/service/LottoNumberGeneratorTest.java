package step2.service;

import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    @RepeatedTest(value = 10, name = "로또 번호 발생 시 결과 6개인지 확인하는 테스트")
    void testGenerateLottoNumbers_6개_결과_확인() {
        List<Integer> result = lottoNumberGenerator.generateLottoNumbers();
        assertThat(result).hasSize(6);
    }

    @RepeatedTest(value = 10, name = "로또 번호 발생 시 정렬이 잘 돼 있는지 확인하는 테스트")
    void testGenerateLottoNumbers_정렬_확인() {
        List<Integer> result = lottoNumberGenerator.generateLottoNumbers();
        assertThat(result).isSorted();
    }
}
