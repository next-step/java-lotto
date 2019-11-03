package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step2.helper.LottoHelper.makeLottoNumbersHelper;

class LottoTicketTest {

    private static Stream<List<LottoNumber>> getInvalidSizeLottoNumbers() {
        List<LottoNumber> lessSizeNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        lessSizeNumbers.remove(0);

        List<LottoNumber> overSizeNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        overSizeNumbers.add(new LottoNumber(45));

        return Stream.of(lessSizeNumbers, overSizeNumbers);
    }

    @Test
    void 로또티켓생성() {
        List<LottoNumber> lottoNumbers = makeLottoNumbersHelper(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertThat(lottoTicket).isEqualTo(new LottoTicket(lottoNumbers));
    }

    @ParameterizedTest
    @MethodSource("getInvalidSizeLottoNumbers")
    void 정해진_갯수만큼_번호를_들고있는지_확인(List<LottoNumber> invalidSizeNumbers) {
        int invalidSize = invalidSizeNumbers.size();

        assertThatThrownBy(() -> new LottoTicket(invalidSizeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidSize + "는 올바르지 않은 갯수입니다.");
    }
}