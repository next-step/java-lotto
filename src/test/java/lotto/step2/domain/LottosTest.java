package lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("Lottos 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5:5", "10:10", "14:14"}, delimiter = ':')
    void lottos_of(int input, int expected) {
        LottoGenerator lottoGenerator = LottoGenerator.getInstance();
        List<Lotto> lottos = IntStream.range(0, input)
                .mapToObj(i ->
                        Lotto.of(lottoGenerator.generateShuffledNumbers())
                )
                .collect(Collectors.toList());

        assertThat(Lottos.of(lottos).getSize()).isEqualTo(expected);
    }
}
