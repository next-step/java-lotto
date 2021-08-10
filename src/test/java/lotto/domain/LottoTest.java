package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class LottoTest {

    @DisplayName("객체생성")
    @Test
    void Lotto_객체생성() {
        assertThat(new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15))).isInstanceOf(Lotto.class);
        assertThat(Lotto.valueOf("1,4,6,9,10,15")).isInstanceOf(Lotto.class);
    }

    @DisplayName("숫자입력-숫자가 6개가 아니면 예외 throw")
    @Test
    void Lotto_숫자가_6개가_아님_숫자입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15, 17));
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("문자열입력-숫자가 6개가 아니면 예외 throw")
    @Test
    void Lotto_숫자가_6개가_아님_문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.valueOf("1,4,6,9,10,15,17");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("숫자입력-중복된 숫자가 있으면 예외 throw")
    @Test
    void Lotto_중복된_숫자_숫자입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 9, 15));
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("문자열입력-중복된 숫자가 있으면 예외 throw")
    @Test
    void Lotto_중복된_문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.valueOf("1,4,6,9,9,15");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("숫자입력-중복된 숫자가 있으면 예외 throw")
    @Test
    void matchingNumber_중복된_숫자_숫자입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 9, 15));
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("문자열입력-중복된 숫자가 있으면 예외 throw")
    @Test
    void matchingNumber_중복된_숫자_문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.valueOf("1,4,6,9,9,15");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("매칭되는 숫자 갯수 확인")
    @Test
    void matchingNumber_매칭되는_숫자_갯수_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15));
        assertThat(lotto.getMatchingCount(Lotto.valueOf("1,4,6,9,15,20"))).isEqualTo(new MatchingCount(5));
    }

    @DisplayName("해당 숫자가 있으면 true")
    @Test
    void matchingNumber_해당_숫자가_있으면_true() {
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15));
        assertThat(lotto.addMatchingCount(new LottoNumber(1))).isTrue();
    }

    @DisplayName("해당 숫자가 없으면 false")
    @Test
    void matchingNumber_해당_숫자가_없으면_false() {
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15));
        assertThat(lotto.addMatchingCount(new LottoNumber(2))).isFalse();
    }

}
