package application;

import domain.Number;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    @Test
    public void 로또여러장구매() {
        int price = 14000;
        LottoGame game = new LottoGame(price);

        assertThat(game.getSize()).isEqualTo(14);
    }

    @Test
    public void 당첨번호입력() {
        String winningNumber = "1, 2, 3, 4, 5, 6";
        List<Number> numbers = new ArrayList();
        Arrays.stream(winningNumber.split(", ")).forEach(v -> numbers.add(new Number(Integer.parseInt(v))));

        assertThat(numbers.size()).isEqualTo(6);
        assertThat(numbers.get(0).getValue()).isEqualTo(1);
    }

    @Test
    public void 당첨확인_세개일치() {

    }
}
