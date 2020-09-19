package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    public Lotto lotto;
    public List<Integer> numbers = new ArrayList<>();

    @Test
    @DisplayName("로또 생성되는지")
    public void createLotto() {
        for(int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        assertThat(lotto.generateLotto(numbers))
                .isExactlyInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("로또 번호 가져오는지")
    public void getLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int i = 1; i < 7; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        lotto = new Lotto(lottoNumbers);
        assertThat(lotto.getLottoNumber()).isEqualTo("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("로또 번호 중복시 에러")
    public void duplicateLottoNumber() {
        numbers.add(1);
        numbers.add(1);
        Lotto lotto = null;

        assertThatThrownBy(() -> lotto.generateLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("로또 개수 초과시")
    public void overLottoDigit() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int i = 1; i < 9; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 총 6개의 번호로 이뤄져 있습니다.");
    }

    @Test
    @DisplayName("당첨 번호 포함여부")
    public void contains() {
        LottoNumber winningNumberTrue = new LottoNumber(1);
        LottoNumber winningNumberFalse = new LottoNumber(11);
        for(int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        lotto = lotto.generateLotto(numbers);

        assertThat(lotto.contains(winningNumberTrue)).isTrue();
        assertThat(lotto.contains(winningNumberFalse)).isFalse();
    }

    @Test
    @DisplayName("당첨 번호 몇 개 포함 됐는지 테스트")
    public void matchLotto() {
        for(int i = 1; i < 7; i++) {
            numbers.add(i);
        }
        lotto = lotto.generateLotto(numbers);
        Lotto winningLotto = lotto.generateLotto(numbers);

        assertThat(lotto.matchLotto(winningLotto)).isEqualTo(Rank.FIRST);
    }
}
