package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    InputStream inputStream;
    OutputStream outputStream;

    @BeforeEach
    void 초기화() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 구매로또출력() {
        List<Number> numbers = List.of(new Number(1),new Number(2),new Number(3),new Number(4),new Number(5),new Number(6));
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<14; i++) {
            lottos.add(new Lotto(numbers));
        }
        InputView.printPurchaseComplete(new Lottos(lottos, lottos.size()));
        assertThat(outputStream.toString()).containsPattern("(\\[[\\d]{1,2}(, [\\d]{1,2}){5}\\]\n){14}");
    }

    @Test
    void 구매완료() {
        List<Number> numbers = List.of(new Number(1),new Number(2),new Number(3),new Number(4),new Number(5),new Number(6));
        List<Lotto> lottos = new ArrayList<>();
        for (int i=0; i<14; i++) {
            lottos.add(new Lotto(numbers));
        }
        InputView.printPurchaseComplete(new Lottos(lottos, lottos.size()));
        assertThat(outputStream.toString()).containsPattern("14개를 구매했습니다.");
    }

    @Test
    void 당첨번호입력() {
        inputStream = new ByteArrayInputStream("1, 2, 3, 4, 5, 6".getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        assertAll(
            () -> assertThat(InputView.askWinningNumbers()).isEqualTo(List.of(new Number(1),new Number(2),new Number(3),new Number(4),new Number(5),new Number(6))),
            () -> assertThat(outputStream.toString()).containsPattern("지난 주 당첨 번호를 입력해 주세요.")
        );
    }

    @Test
    void 구입금액입력() {
        inputStream = new ByteArrayInputStream("14000".getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        assertAll(
            () -> assertThat(InputView.askAmount()).isEqualTo(14000),
            () -> assertThat(outputStream.toString()).containsPattern("구입금액을 입력해 주세요.")
        );
    }

}
