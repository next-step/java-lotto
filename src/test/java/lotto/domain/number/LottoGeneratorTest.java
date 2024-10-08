package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @Test
    @DisplayName("반환된 LottoNumber 배열에는 정렬된 무작위 수가 존재한다. 리스트 요소가 (1,2,3,4,5,6)이면 안됨")
    void 무작위_번호_6개_생성() {
        List<Integer> integers = LottoGenerator.generate()
                .stream()
                .map(LottoNumber::number)
                .collect(Collectors.toList());
        List<Integer> sequence = List.of(1, 2, 3, 4, 5, 6);

        assertThat(integers)
                .isSorted();
        assertThat(integers).doesNotContainSequence(sequence);
    }
}
