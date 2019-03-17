package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {

    @Test
    public void 문자열_콤마_분리() {
        String expression = "1,2,3";
        int[] results = Expression.extractOperands(expression);

        for (int i = 0; i < results.length; i++) {
            assertThat(results[i]).isEqualTo(i+1);
        }
    }

    @Test
    public void 문자열_콜론_분리() {
        String expression = "1:2:3";
        int[] result = Expression.extractOperands(expression);

        for (int i = 0; i < result.length; i++) {
            assertThat(result[i]).isEqualTo(i+1);
        }
    }

    @Test
    public void 입력값이_nullOrEmpty() {
        boolean isNullOrEmpty = Expression.isNullOrEmpty("");
        assertThat(isNullOrEmpty).isEqualTo(true);

        isNullOrEmpty = Expression.isNullOrEmpty(null);
        assertThat(isNullOrEmpty).isEqualTo(true);

        isNullOrEmpty = Expression.isNullOrEmpty("하하");
        assertThat(isNullOrEmpty).isEqualTo(false);
    }

    @Test
    public void 숫자_하나만_들어온_경우() {
        boolean isSingleNumber = Expression.isSingleNumber("12547");
        assertThat(isSingleNumber).isEqualTo(true);

        isSingleNumber = Expression.isSingleNumber("12547:52");
        assertThat(isSingleNumber).isEqualTo(false);
    }

    @Test(expected = RuntimeException.class)
    public void 숫자변환_비정상데이터_예외처리() {
        int[] results = Expression.extractOperands("12547:하하");
        System.out.println("check result");
        assertThat(results[1]).isEqualTo("하하");
    }

    @Test(expected = RuntimeException.class)
    public void 입력값이_음수인경우_예외처리() {
        int[] results = Expression.extractOperands("123:-100");
        System.out.println("check result");
        assertThat(results[1]).isEqualTo(-100);
    }

    @Test
    public void 커스텀구분자_인식하기() {
        int[] result = Expression.extractOperands("//;\n1;2;3");

        for (int i = 0; i < result.length; i++) {
            assertThat(result[i]).isEqualTo(i+1);
        }
    }
}
