package lotto;

import lotto.domain.AllLottoNumber;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class AllLottoNumberTest {

    @Test
    @DisplayName("[성공] 1부터 45까지의 중복되지 않는 번호를 생성한다.")
    void 중복되지_않는_번호_생성() {
        List<LottoNumber> numbers = AllLottoNumber.shuffle();
        assertThat(numbers).containsAll(getPossibleLottoNumbers());
    }

    private Set<LottoNumber> getPossibleLottoNumbers() {
        return IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
