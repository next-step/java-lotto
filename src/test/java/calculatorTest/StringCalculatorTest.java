package calculatorTest;

import org.junit.Test;

import static calculator.StringCalculator.add;
import static calculator.StringCalculator.ifCustomRegex;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StringCalculatorTest {

    @Test
    public void Add_공백(){
        int result = add("");
        assertThat(result).isEqualTo(0);

    }
    @Test
    public void Add_한개(){
        int result = add("4");
        assertThat(result).isEqualTo(4);
    }
    @Test
    public void Add_두개이상(){
        int result = add("4,5,6");
        assertThat(result).isEqualTo(15);
    }
    @Test
    public void Add_콜론조건추가(){
        int result = add("4,5:6");
        assertThat(result).isEqualTo(15);

    }
/*    @Test
    public void Add_커스텀문자출력하기(){
        String result = ifCustomRegex("//;\\n1;2;3",",|:");
        assertThat(result).isEqualTo(",|:|;");
    }*/




}
