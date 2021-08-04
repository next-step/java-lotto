package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @DisplayName("객체생성")
    @Test
    void Lotto_객체생성() {
        assertThat(new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15))).isInstanceOf(Lotto.class);
        assertThat(new Lotto("1,4,6,9,10,15")).isInstanceOf(Lotto.class);
    }

    @DisplayName("숫자가 6개가 아니면 예외 throw")
    @Test
    void Lotto_숫자가_6개가_아님() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15, 17));
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1,4,6,9,10,15,17");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("중복된 숫자가 있으면 예외 throw")
    @Test
    void Lotto_중복된_숫자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 9, 15));
        }).withMessageMatching("중복된 숫자가 있습니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1,4,6,9,9,15");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("중복된 숫자가 있으면 예외 throw")
    @Test
    void matchingNumber_중복된_숫자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 4, 6, 9, 9, 15));
        }).withMessageMatching("중복된 숫자가 있습니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1,4,6,9,9,15");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("숫자가 있는지 확인")
    @Test
    void matchingNumber_숫자가_있는지_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 4, 6, 9, 10, 15));

        assertThat(lotto.matchingNumber(new LottoNumber(1))).isTrue();
        assertThat(lotto.matchingNumber(new LottoNumber(7))).isFalse();
    }

}
