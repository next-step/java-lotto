package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersFactoryTest {

    @DisplayName("중복되지 않은 숫자들을 얻을 수 있다.")
    @Test
    void canCreateNonDuplicateNumbers() {
        List<LottoNumber> nonDuplicateNumbers = NumbersFactory.createNonDuplicateNumbers(6);
        assertThat(nonDuplicateNumbers).isNotNull();

        Set<LottoNumber> set = new HashSet<>(nonDuplicateNumbers);
        assertThat(nonDuplicateNumbers.size()).isEqualTo(set.size());
    }

    @DisplayName("수동 문자열 숫자를 숫자 리스트로 생성할 수 있다.")
    @Test
    void canCreateManualNumbers() {
        String numbers = "1, 2, 3, 4, 5, 6";
        List<LottoNumber> manualNumbers = NumbersFactory.createManualNumbers(numbers);

        assertThat(manualNumbers).isNotNull();

        int manualNumberSize = numbers.split(", ").length;
        assertThat(manualNumbers.size()).isEqualTo(manualNumberSize);
    }
}
