package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottoGenerationTest {

    @DisplayName("번호 생성 테스트")
    @Test
    void getGeneratedLottosTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGeneration lottoGeneration = new LottoGeneration(numbers, 1000);
        List<Lotto> generatedLottos = lottoGeneration.getGeneratedLottos();

        Set<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());

        Lotto lotto = new Lotto(lottoNumbers);

        assertTrue(generatedLottos.contains(lotto));
    }

    @DisplayName("번호 생성 갯수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1","2000:2","100000:100","33000:33", "55999:55", "88777:88"}, delimiter = ':')
    void getGeneratedLottosSizeTest(int cash, int counnt) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGeneration lottoGeneration = new LottoGeneration(numbers, cash);
        List<Lotto> generatedLottos = lottoGeneration.getGeneratedLottos();

        assertEquals(generatedLottos.size(), counnt);
    }

}