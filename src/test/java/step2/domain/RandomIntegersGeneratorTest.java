package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomIntegersGeneratorTest {

    @DisplayName("랜덤 숫자 배열의 디폴트 길이는 6이다.")
    @Test
    public void 랜덤_숫자_생성_배열크기검증() throws Exception {
        int defaultNumbersLength = 6;
        assertThat(RandomIntegersGenerator.createNumberList())
                .size()
                .isEqualTo(defaultNumbersLength);
    }

    @DisplayName("랜덤 숫자 배열의 범위는 1부터 45까지이다.")
    @Test
    public void 랜덤_숫자_생성_배열범위검증() throws Exception {
        List<Integer> numberList = RandomIntegersGenerator.createNumberList(45);
        for (Integer number : numberList) {
            assertThat(number).isPositive().isLessThan(46);
        }
    }

    @DisplayName("랜덤 숫자 생성 결과값을 출력한다.")
    @Test
    public void 랜덤_숫자_생성_배열_출력() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println(RandomIntegersGenerator.createNumberList(6));
        }
    }

}
