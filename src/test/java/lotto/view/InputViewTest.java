package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사용자 입력 뷰 테스트")
public class InputViewTest {

    @DisplayName("구입금액 입력")
    @ParameterizedTest
    @CsvSource(value = {"100:100", "15000:15000"}, delimiter = ':')
    public void enterMoney(String input, int expectedMoney) {
        InputView inputView = new InputView(new Scanner(input), new PrintWriter(System.out));

        int money = inputView.getMoney();

        assertThat(money).isEqualTo(expectedMoney);
    }

    @DisplayName("구입금액 입력시 문구")
    @Test
    public void showPhraseForMoney() {
        StringWriter output = new StringWriter();
        InputView inputView = new InputView(new Scanner("1000"), new PrintWriter(output));

        inputView.getMoney();

        assertThat(output.toString()).isEqualTo("구입금액을 입력해 주세요.\n");
    }
}