package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitDomainTest {
    private SplitDomain splitDomain;

    @BeforeEach
    public void setup() {
        splitDomain = new SplitDomain();
    }

    @Test
    public void add_숫자하나() throws Exception {
        int[] onlyOneInputNumberTest = {1};
        assertThat((splitDomain.onlyOneInputNumber("1"))).isEqualTo(onlyOneInputNumberTest);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        int[] basicSplitInputNumber = {1, 2};
        assertThat(splitDomain.basicSplitInputNumber("1,2")).isEqualTo(basicSplitInputNumber);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        int[] splitTokensNumber = {1, 2, 3};
        assertThat(splitDomain.splitTokensNumber("1,2:3")).isEqualTo(splitTokensNumber);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        int[] customizeSplitInputNumber = {1, 2, 3};
        assertThat(splitDomain.customizeSplitInputNumber("//;\n1;2;3")).isEqualTo(customizeSplitInputNumber);
    }
}
