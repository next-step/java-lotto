package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTest {

    private LottoNumber num1;
    private LottoNumber num2;
    private LottoNumber num3;
    private LottoNumber num4;
    private LottoNumber num5;
    private LottoNumber num6;
    private LottoNumber num7;

    @BeforeEach
    void setUp() {
        num1 = LottoNumber.of(1);
        num2 = LottoNumber.of(19);
        num3 = LottoNumber.of(30);
        num4 = LottoNumber.of(34);
        num5 = LottoNumber.of(35);
        num6 = LottoNumber.of(41);
        num7 = LottoNumber.of(44);
    }

    @Test
    @DisplayName("로또번호가 중복되지 않고 개수가 6개일 때 LottoTicket 생성")
    void successByCreation() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(num1, num2, num3, num4, num5, num6));
        assertThat(lottoTicket.getLottoNumbers()).containsExactly(
                num1.getNumber(), num2.getNumber(), num3.getNumber(),
                num4.getNumber(), num5.getNumber(), num6.getNumber());
    }

    @Test
    @DisplayName("로또번호가 중복일때 IllegalArgumentException")
    void exceptByDuplicatedCreation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoTicket(Arrays.asList(num1, num2, num3, num4, num5, num5));
        }).withMessage("로또 번호는 중복 될 수 없습니다.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoTicket(Arrays.asList(num1, num2, num3, num4, num5, num5, num6));
        }).withMessage("로또 번호는 중복 될 수 없습니다.");
    }

    @Test
    @DisplayName("로또번호가 6개가 아닐때 throw IllegalArgumentException")
    void exceptByNotMatchSizeCreation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoTicket(Arrays.asList(num1, num2, num3, num4, num5));
        }).withMessage("로또 번호는 6개만 가능합니다.");

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoTicket(Arrays.asList(num1, num2, num3, num4, num5, num6, num7));
        }).withMessage("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("생성 시로 로또 번호 순서에 상관 없이 로또 번호 오름차순 정렬")
    void sortByGet() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(num2, num3, num5, num4, num1, num6));
        assertThat(lottoTicket.getLottoNumbers()).containsExactly(
                num1.getNumber(), num2.getNumber(), num3.getNumber(),
                num4.getNumber(), num5.getNumber(), num6.getNumber());
    }
}