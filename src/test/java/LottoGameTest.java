import domain.LottoGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameTest {
    int purchasePrice = 14000;
    String count;
    LottoGame lottoGame;

    @BeforeEach
    void setup() {

        lottoGame = new LottoGame(purchasePrice);
    }

    @Test
    void 로또_구매가격체크() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if (purchasePrice < 1000) {
                throw new IllegalArgumentException("입력이 잘못되었습니다. 지난 당첨 번호를 다시 한번 입력해주세요.");
            }
        });
    }

    @Test
    void 구매가격_로또개수_추출() {
        String priceStr = String.valueOf(purchasePrice);
        count = priceStr.substring(0, priceStr.length() - 3);
        assertThat(Integer.parseInt(count)).isEqualTo(14);
    }

    @Test
    void 지난_당첨번호_체크() {
        int[] arr = {1, 2, 3, 4, 5};
        int size = arr.length;
        assertThat(size != 6).isTrue();
    }

    @Test
    void 공백제거_문자열_자르기() {
        String first_input = "1, 2, 3, 4, 5, 6";
        String[] splitResut = first_input.replaceAll(" ", "").split(",");
        assertThat(splitResut).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @Test
    void 배열을_문자열로_변환() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        String temp = Arrays.toString(arr);
        System.out.println(temp);
        String arrayToStr = temp.substring(1, temp.length() - 1).replace(", ", "");
        assertThat(arrayToStr).isEqualTo("123456");
    }

    @Test
    void 지난_당첨번호와_비교_보너스볼_매치_여부_확인() {
        int wingingCount = 0;
        int[] prvLottoNumber = {1, 2, 3, 4, 8, 7};
        int bonusBall = 5;
        int countBonusBall = 0;
        ArrayList<Integer> lottoElement = new ArrayList<>();
        for (int i = 1; i <= prvLottoNumber.length; i++) {
            lottoElement.add(i);
        }
        for (int i = 0; i < prvLottoNumber.length; ++i) {
            wingingCount = lottoElement.contains(prvLottoNumber[i]) ? wingingCount + 1 : wingingCount;
        }
        assertThat(wingingCount).isEqualTo(4);

        if (wingingCount == 4 && lottoElement.contains(bonusBall)) {
            ++countBonusBall;
        }
        assertThat(countBonusBall).isEqualTo(1);
    }

    @Test
    void 수익률을_소수점_2자리까지_만들기() {
        double revenue = 2332.323487;
        String[] result = String.valueOf(revenue).split("\\.");
        String percent = null;
        if (result[1].length() == 1)
            percent = result[0] + "." + result[1].substring(0, 1);
        if (result[1].length() > 1)
            percent = result[0] + "." + result[1].substring(0, 2);
        assertThat(percent).isEqualTo("2332.32");
    }
}
