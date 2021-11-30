package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author han
 */
class LottoNumberFactoryTest {

    LottoNumberFactory factory;

    @BeforeEach
    void setUp() {
        factory = LottoNumberFactory.getInstance();
    }

    @Test
    @DisplayName("중복된 로또 넘버들을 반환하지 않는다")
    void createNonDuplicated() {
        List<LottoNumber> nonDuplicated = factory.getNonDuplicated();
        assertThat(nonDuplicated.size()).isEqualTo(new HashSet<>(nonDuplicated).size());
    }

    @Test
    @DisplayName("String을 통해 로또 생성 시, 중복된 로또 넘버들을 반환하지 않는다")
    void createNonDuplicatedByStrings() {
        List<LottoNumber> nonDuplicated = factory.getNonDuplicated("1,2,3,4,5,6");
        assertThat(nonDuplicated.size()).isEqualTo(new HashSet<>(nonDuplicated).size());
    }
}