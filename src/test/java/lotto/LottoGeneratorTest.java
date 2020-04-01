package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private static LottoGenerator lottoGenerator = LottoGenerator.getLottoGenerator();

    @DisplayName("1~45 사이의 숫자 로또번호를 자동 구매 수량 만큼 생성한다.")
    @Test
    void generateRandomNumbers() {
        LottoTicket lottoTicket = lottoGenerator.createAutomaticLottoTicket(14);
        assertThat(lottoTicket.getLottoNumbers()).hasSize(14);
    }

}
