package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @DisplayName("객체생성")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void Lotto_객체생성() {
        assertThat(new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15))).isInstanceOf(Lotto.class);
        assertThat(Lotto.valueOf("1,4,6,9,10,15")).isInstanceOf(Lotto.class);
    }

    @DisplayName("숫자입력-숫자가 6개가 아니면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void Lotto_숫자가_6개가_아님_숫자입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15, 17));
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("문자열입력-숫자가 6개가 아니면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void Lotto_숫자가_6개가_아님_문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.valueOf("1,4,6,9,10,15,17");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("숫자입력-중복된 숫자가 있으면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void Lotto_중복된_숫자_숫자입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 9, 15));
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("문자열입력-중복된 숫자가 있으면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void Lotto_중복된_문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.valueOf("1,4,6,9,9,15");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("숫자입력-중복된 숫자가 있으면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void matchingNumber_중복된_숫자_숫자입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 9, 15));
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("문자열입력-중복된 숫자가 있으면 예외 throw")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void matchingNumber_중복된_숫자_문자열입력() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.valueOf("1,4,6,9,9,15");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("숫자가 있는지 확인")
    @SuppressWarnings("NonAsciiCharacters")
    @Test
    void matchingNumber_숫자가_있는지_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15));
        assertThat(lotto.getMatchingCount(Lotto.valueOf("1,4,6,9,15,20"))).isEqualTo(new MatchingCount(5));
    }

}
