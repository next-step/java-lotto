package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author han
 */
class LottoNumberFactoryTest {

    @Test
    @DisplayName("중복된 로또 넘버들을 반환하지 않는다")
    void createNonDuplicated() {
        List<LottoNumber> nonDuplicated = new LottoNumberFactory().getNonDuplicated();
        assertThat(nonDuplicated.size()).isEqualTo(new HashSet<>(nonDuplicated).size());
    }
}