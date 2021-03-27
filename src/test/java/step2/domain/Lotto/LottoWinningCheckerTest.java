package step2.domain.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.dto.LottoConfirmationRequestDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningCheckerTest {

    private LottoConfirmationRequestDto confirmationRequestDto;

    @BeforeEach
    void setUp() {
        String sentence = "1, 2, 3, 4, 5, 6";
        confirmationRequestDto = LottoConfirmationRequestDto.newInstance(sentence);
    }

    @DisplayName("LottoWinningChecker 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoWinningChecker winningChecker = LottoWinningChecker.getInstance(confirmationRequestDto);

        // then
        assertThat(winningChecker).isNotNull();

    }
}