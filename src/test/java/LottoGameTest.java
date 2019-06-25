import domain.LottoGame;
import domain.LottoNumber;
import domain.LottoResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    int price = 14000;
    String result;
    LottoNumber lottoNumber;
    LottoResult lottoResult;
    LottoGame lottoGame;


    @BeforeEach
    void setup() {
        String priceStr = String.valueOf(price);
        result = priceStr.substring(0, priceStr.length() - 3);

    }

    @Test
    @DisplayName("가격을 숫자로 자르기")
    void substringPricetoNumber() {
        assertThat(result).isEqualTo("14");
    }

    @Test
    @DisplayName("1000원보다 낮은 가격 입력이 되었을때 exception")
    void checkPrice() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
                    if (price > 1000)
                        throw new IllegalArgumentException("입력값이 잘못되었습니다. 가격을 다시 한번 입력해주세요.");
                }
        );
    }

    @Test
    void getAutoLottoNumber() {
        List<Integer> lotto = new ArrayList<>();
        List<Integer> element = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            element.add(i);
        }

        Collections.shuffle(element);
        int numberOfLotto = Integer.parseInt(result);

        for (int i = 0; i < numberOfLotto; i++) {
            lotto.add(element.get(i));
        }

        Collections.sort(lotto);
    }

    @Test
    void getNumberofWin() {
        int numofWin = 0;
        List<Integer> lotto = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lotto.add(i);
        }

        for (int i = 1; i <= 45; i++) {
            if (lotto.contains(i))
                ++numofWin;
        }
        assertThat(numofWin).isEqualTo(6);
    }

    @Test
    void getRevenue() {
        int forth = 1;
        int third = 0;
        int second = 0;
        int first = 0;

        int total = (5000 * forth) + (50000 * third) + (1500000 * second) + (2000000000 * first);
        double revenue = total / (double) price;
        String result = String.valueOf(revenue).substring(0, 4);

        assertThat(result).isEqualTo("0.35");
    }

    @Test
    void removeBlankAndSplit() {
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(input.replaceAll(" ", "").split(",")).containsExactly("1", "2", "3", "4", "5", "6");
    }
    @Test
    void getPercentOfRevenue(){
        double revenue = 2332.323;
        String[] result=String.valueOf(revenue).split("\\.");
        String percent = result[0] +"."+result[1].substring(0,2);
        assertThat(percent).isEqualTo("2332.32");
    }

}
