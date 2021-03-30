package step2.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.checker.LottoWinningChecker;
import step2.dto.LottoWinningCheckRequestDto;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningCheckerTest {

    private LottoWinningCheckRequestDto confirmationRequestDto;

    @BeforeEach
    void setUp() {
        String sentence = "1, 2, 3, 4, 5, 6";
        confirmationRequestDto = LottoWinningCheckRequestDto.newInstance(sentence);
    }

    @DisplayName("LottoWinningChecker 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoWinningChecker winningChecker = LottoWinningChecker.of(confirmationRequestDto);

        // then
        assertThat(winningChecker).isNotNull();

    }


}