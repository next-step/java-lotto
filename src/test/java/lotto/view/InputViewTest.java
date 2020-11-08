package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("사용자 입력 뷰 테스트")
public class InputViewTest {

    private StringWriter stringWriter = new StringWriter();
    private PrintWriter systemWriter = new PrintWriter(System.out);

    @DisplayName("구입금액 입력")
    @ParameterizedTest
    @CsvSource(value = {"100:100", "15000:15000"}, delimiter = ':')
    public void enterMoney(String input, int expectedMoney) {
        InputView inputView = new InputView(new Scanner(input), systemWriter);

        int money = inputView.getMoney();

        assertThat(money).isEqualTo(expectedMoney);
    }

    @DisplayName("구입금액 입력시 문구")
    @Test
    public void showPhraseForMoney() {
        InputView inputView = new InputView(new Scanner("1000"), new PrintWriter(stringWriter));

        inputView.getMoney();

        assertThat(stringWriter.toString()).isEqualTo("구입금액을 입력해 주세요.\n");
    }

    @DisplayName("지난주 당첨번호 입력")
    @ParameterizedTest
    @MethodSource("getLastLottoNumbers")
    public void enterLastWeekLottoNumber(String input, Integer[] expectedLastNumbers) {
        InputView inputView = new InputView(new Scanner(input), systemWriter);

        List<Integer> lastLottoNumbers = inputView.getLastLottoNumbers();

        assertThat(lastLottoNumbers).containsOnly(expectedLastNumbers);
    }

    static Stream<Arguments> getLastLottoNumbers() {
        return Stream.of(
                arguments("1, 2, 3, 4, 5, 6", new Integer[]{1, 2, 3, 4, 5, 6}),
                arguments("3, 4, 5, 6, 7, 8", new Integer[]{3, 4, 5, 6, 7, 8})
        );
    }

    @DisplayName("지난주 당첨번호 입력시 문구")
    @Test
    public void showPhraseForLastLottoNumbers() {
        InputView inputView = new InputView(new Scanner("3, 4, 5, 6, 7, 9"), new PrintWriter(stringWriter));

        inputView.getLastLottoNumbers();

        assertThat(stringWriter.toString()).isEqualTo("지난 주 당첨 번호를 입력해 주세요.\n");
    }

    @DisplayName("보너스 볼 입력")
    @ParameterizedTest
    @CsvSource(value = {"10:10", "15:15"}, delimiter = ':')
    public void enterBonusBall(String input, int expectedNumber) {
        InputView inputView = new InputView(new Scanner(input), systemWriter);

        int number = inputView.getBonusLottoNumber();

        assertThat(number).isEqualTo(expectedNumber);
    }

    @DisplayName("보너스 볼 입력시 문구")
    @Test
    public void showPhraseForBonusBall() {
        InputView inputView = new InputView(new Scanner("9"), new PrintWriter(stringWriter));

        inputView.getBonusLottoNumber();

        assertThat(stringWriter.toString()).isEqualTo("보너스 볼을 입력해 주세요.\n");
    }
}