package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.LottoNum;
import step2.domain.LottoTicket;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketTest {
    LottoTicket lottoTicket = new LottoTicket();

    @DisplayName("로또 숫자 6개 생성")
    @Test
    void makeAutoNumbersTest() {
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @DisplayName("1~45 범위 내 검사")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,40,45})
    void checkRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNum(46).getLottoNum();
        });
    }

    @DisplayName("1~45 범위 외 검사")
    @Test
    void checkOutOfRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNum(46).getLottoNum();
        });
    }

}
