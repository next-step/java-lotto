package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ElementAdderTest {

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        String input = "1,5:3";
        String[] inputs = input.split(":|,");
        int result = ElementAdder.addAllElements(inputs);
        assertThat(result).isEqualTo(9);
    }
}
