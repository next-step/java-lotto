package lotto.view;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("주어진 로또의 개수와, 로또 숫자들을 출력한다.")
    @Test
    void printGeneratedLotto() {
        List<LottoNumber> lottoNumbers = List.of(
                new LottoNumber(List.of(1, 2, 3, 4, 5, 6)),
                new LottoNumber(List.of(1, 3, 5, 6, 7, 9)),
                new LottoNumber(List.of(2, 4, 6, 8, 10, 12))
        );
        String expected = "3개를 구매했습니다.\n" +
                "[1, 2, 3, 4, 5, 6]\n" +
                "[1, 3, 5, 6, 7, 9]\n" +
                "[2, 4, 6, 8, 10, 12]";

        OutputView.printGeneratedLottoNumbers(lottoNumbers);
        String actual = outputStreamCaptor.toString().trim();

        assertThat(actual).isEqualTo(expected);
    }
}