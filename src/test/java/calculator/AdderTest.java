package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdderTest {

    private Adder adder;

    @Test
    public void 기본_생성자_테스트() {
        this.adder = new Adder();

        assertThat(adder.getResult()).isEqualTo(0);
    }

    @Test
    public void 숫자_생성자_테스트() {
        final int inputValue = 3;
        this.adder = new Adder(inputValue);

        assertThat(adder.getResult()).isEqualTo(inputValue);
    }

    @Test
    public void 문자열_생성자_테스트() {
        final String stringNumber = "5";
        this.adder = new Adder(stringNumber);

        assertThat(this.adder.getResult()).isEqualTo(Integer.parseInt(stringNumber));
    }

    @Test
    public void 기본_더하기_테스트() {
        final int inputValue = 3;
        this.adder = new Adder(inputValue);

        adder.add();

        assertThat(adder.getResult()).isEqualTo(inputValue + 1);
    }

    @Test
    public void 숫자_더하기_테스트() {
        final int inputValue = 3;
        this.adder = new Adder(inputValue);

        adder.add(inputValue);

        assertThat(adder.getResult()).isEqualTo(inputValue + inputValue);
    }

    @Test
    public void 문자열_숫자_더하기_테스트() {
        final String stringNumber = "4";
        final int intNumber = Integer.parseInt(stringNumber);
        this.adder = new Adder(stringNumber);

        adder.add(stringNumber);

        assertThat(adder.getResult()).isEqualTo(intNumber + intNumber);
    }

    @Test
    public void 문자열_숫자_배열_생성자() {
        final String[] stringNumbers = {"1", "2", "3"};

        Adder adder = new Adder(stringNumbers);

        assertThat(adder.getResult()).isEqualTo(6);
    }

    @Test
    public void 문자열_숫자_배열_더하기() {
        final String[] stringNumbers = {"1", "2", "4"};
        Adder adder = new Adder();

        adder.adds(stringNumbers);

        assertThat(adder.getResult()).isEqualTo(7);
    }

}