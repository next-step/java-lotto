package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumbersTest {
    @Test
    @DisplayName("로또번호가 중복되지 않고 개수가 6개일 때 LottoTicket 생성")
    void successByCreation() {
        LottoNumbers lottoNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoNumbers.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또번호가 중복일때 IllegalArgumentException")
    void exceptByDuplicatedCreation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumbers.of(1, 2, 3, 4, 5, 1);
        }).withMessage("로또 번호는 중복 될 수 없습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumbers.of(1, 1, 3, 3, 5, 6);
        }).withMessage("로또 번호는 중복 될 수 없습니다.");
    }

    @Test
    @DisplayName("로또번호가 6개가 아닐때 throw IllegalArgumentException")
    void exceptByNotMatchSizeCreation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumbers.of(1, 2, 3, 4, 5);
        }).withMessage("로또 번호는 6개만 가능합니다.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumbers.of(1, 2, 3, 4, 5, 6, 7);
        }).withMessage("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("생성 시로 로또 번호 순서에 상관 없이 로또 번호 오름차순 정렬")
    void sortByGet() {
        LottoNumbers lottoNumbers = LottoNumbers.of(5, 3, 4, 1, 2, 6);
        assertThat(lottoNumbers.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("포함 여부")
    void contain() {
        LottoNumbers lottoNumbers = LottoNumbers.of(5, 3, 4, 1, 2, 6);

        assertThat(lottoNumbers.contains(LottoNumber.of(1))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(3))).isTrue();
        assertThat(lottoNumbers.contains(LottoNumber.of(11))).isFalse();
    }

    @Test
    @DisplayName("매치 카운트")
    void match() {
        LottoNumbers lottoNumbers = LottoNumbers.of(5, 3, 4, 1, 2, 6);

        assertThat(lottoNumbers.match(LottoNumbers.of(1, 2, 3, 11, 12, 13))).isEqualTo(3);
        assertThat(lottoNumbers.match(LottoNumbers.of(1, 2, 3, 4, 5, 13))).isEqualTo(5);
    }
}