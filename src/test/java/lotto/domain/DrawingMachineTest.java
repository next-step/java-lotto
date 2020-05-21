package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class DrawingMachineTest {
    @DisplayName("생성자로 입력받은 당첨 번호의 개수가 6이 아니면 IllegalArgumentException throw")
    @Test
    void notCorrectWinningNumberSizeThrowException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new DrawingMachine(Arrays.asList(1, 2, 3, 4, 5)))
                .withMessage("당첨 번호의 개수가 6이 아닙니다.");
    }

    @DisplayName("생성자로 입력받은 당첨 번호가 중복되는 값이 있으면 IllegalArgumentException throw")
    @Test
    void duplicateWinningNumberThrowException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new DrawingMachine(Arrays.asList(1, 2, 3, 3, 5, 6)))
                .withMessage("당첨 번호는 중복될 수 없습니다.");
    }

    @DisplayName("로또 티켓과 당첨 번호를 비교하여 맞은 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "10,11,12,22,33,44:0"}, delimiter = ':')
    void drawLotto(String winningNumber, int matchCount) {
        LottoTicket lottoTicket = createLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        DrawingMachine drawingMachine = new DrawingMachine(winningNumbers);

        int actualMatchCount = drawingMachine.drawLottoTicket(lottoTicket);

        assertThat(actualMatchCount).isEqualTo(matchCount);
    }

    private LottoTicket createLottoTicket(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}