package lotto_step1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddStringSplitTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringSplit.isBlank(null);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringSplit.isBlank("");
        });
    }

    @Test
    public void splitAndSum_숫자하나() {
        List<String> result = StringSplit.splitInputValue("1","");
        assertThat(result.get(0)).isEqualTo("1");
    }

    @Test
    public void splitAndSum_쉼표구분자() {
        List<String> testStringList = new ArrayList<>();
        testStringList.add("1");
        testStringList.add("2");

        List<String> result = StringSplit.splitInputValue("1,2", "");
        Assert.assertEquals(result, testStringList);
    }

    @Test
    public void splitAndSum_콜론구분자() {
        List<String> testStringList = new ArrayList<>();
        testStringList.add("1");
        testStringList.add("2");

        List<String> result = StringSplit.splitInputValue("1:2", "");
        Assert.assertEquals(result, testStringList);
    }

    @Test
    public void splitAndSum_custom_구분자() {
        String value = "//;\\n1;2;3";

        List<String> splitValues = StringSplit.splitInputValue(value, StringSplit.checkCustomSeparator(value));
        int result = CalculatorSum.sum(splitValues);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringSplit.isNegative("-1");
        });
    }

    @Test
    public void splitAndSum_notNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringSplit.isNumber("a,1");
        });
    }
}