package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoNumberFactoryTest {

    @DisplayName("중복되지 않은 숫자열이 반환된다.")
    @RepeatedTest(100)
    void mustReturnNonDuplicatedIntegerList() {
        LottoNumberFactory lottoNumberFactory = LottoNumberFactory.getInstance();
        Set<LottoNumber> temp = new HashSet<>();
        List<LottoNumber> duplicated = lottoNumberFactory.number().stream()
            .filter(lottoNumber -> !temp.add(lottoNumber))
            .collect(Collectors.toList());
        assertThat(duplicated.isEmpty()).isTrue();
    }
}
