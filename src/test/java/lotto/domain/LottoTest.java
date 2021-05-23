package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("로또 자동생성 - 번호 자동생성됨")
    void generateAuto() {
        Lotto generated = Lotto.auto();

        Set<LottoNumber> numbers = generated.getNumbers();

        assertThat(numbers).hasSize(6);
    }

    @Test
    @DisplayName("지난 주 당첨번호와 매칭 테스트")
    void match() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers, LottoType.MANUAL);

        LottoNumbers winningNumbers = new LottoNumbers(1, 2, 3, 4, 5, 7);
        LottoNumber bonusNumber = LottoNumber.from(6);
        WinningType winningType = lotto.match(winningNumbers, bonusNumber);

        assertThat(winningType).isEqualTo(WinningType.SECOND);
    }

    @Test
    @DisplayName("로또 - 자동 여부 테스트")
    void isAuto() {
        Lotto lotto = Lotto.auto();

        assertThat(lotto.isAuto()).isTrue();
        assertThat(lotto.isManual()).isFalse();
    }

    @Test
    @DisplayName("로또 - 수동 여부 테스트")
    void isManual() {
        Lotto lotto = Lotto.manual(new LottoNumbers(1,2,3,4,5,6));

        assertThat(lotto.isAuto()).isFalse();
        assertThat(lotto.isManual()).isTrue();
    }
}
