package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberGeneratorTest {

    @Test
    @DisplayName("[성공] 1부터 45까지의 중복되지 않는 번호를 생성한다.")
    void 중복되지_않는_번호_생성() {
        List<Integer> numbers = LottoNumberGenerator.generate();
        assertThat(numbers).containsAnyElementsOf(getPossibleLottoNumbers());
    }

    private Set<Integer> getPossibleLottoNumbers() {
        return IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toSet());
    }
}
