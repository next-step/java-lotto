package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("반환된 LottoNumber 배열에는 무작위 수가 존재한다. 기존에 생성된 숫자 리스트와는 항상 달라야함")
    void 무작위_번호_6개_정상_생성() {
        List<List<LottoNumber>> generated = IntStream.range(0, 10)
                .mapToObj(i -> LottoGenerator.generate())
                .collect(Collectors.toList());

        for (int i = 0; i < generated.size() - 1; i++) {
            assertThat(generated.get(i).containsAll(generated.get(i + 1))).isFalse();
        }
    }
}
