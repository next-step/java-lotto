package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("[요구사항 1] 로또 번호 개수가 6개가 아닐 경우 IllegalArgumentException throw")
    void 요구사항_1() {
        // given
        TreeSet<LottoNumber> lottoNumbers = Set.of(1, 2, 3, 4, 5).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));

        // then
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개의 숫자로 구성되어야 합니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 로또 번호 개수가 6개일 경우 정상적으로 로또가 생성된다.")
    void 요구사항_2() {
        // given
        TreeSet<LottoNumber> lottoNumbers = Set.of(1, 2, 3, 4, 5, 6).stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));

        // when
        Lotto createdLotto = new Lotto(lottoNumbers);

        // then
        assertThat(createdLotto.getLottoNumbers()).containsExactlyElementsOf(lottoNumbers);
    }
}
