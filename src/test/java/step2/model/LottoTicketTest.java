package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void create_LottoNumbers_ExceptionThrown() {
        assertThatThrownBy(() -> LottoTicket.create(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("getLottoNumbers()는 입력한 로또번호 리스트를 반환한다")
    @Test
    void getLottoNumbers_None_LottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(lottoNumbers);
    }

    @DisplayName("getLottoNumbers()로 반환된 로또번호 리스트는 수정하려고 하면 예외가 발생한다")
    @Test
    void getLottoNumbers_None_ExceptionThrown() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate();
        LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

        List<LottoNumber> unmodifiableLottoNumbers = lottoTicket.getLottoNumbers();

        assertThatThrownBy(() -> unmodifiableLottoNumbers.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
