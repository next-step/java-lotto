package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberFactoryTest {

    @Test
    @DisplayName("LottoNumberFacotry로 생성한 숫자는 6개의 숫자를 가지며 중복되지 않는다.")
    void createLottoNumber() {
        Set<Integer> uniqueNumbers = new HashSet<>(LottoNumberFactory.generateNumbers());

        assertThat(uniqueNumbers).hasSize(6);
    }

    @Test
    @DisplayName("만들어진 List는 불변객체이며 수정하려할 경우 오류가 발생한다.")
    void createLottoNumber_불변객체() {
        List<Integer> numbers = LottoNumberFactory.generateNumbers();

        assertThatThrownBy(numbers::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }
}