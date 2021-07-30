package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersFactoryTest {
    @Test
    @DisplayName("Delimiters 오브젝트가 맞게 생성되는지 테스트")
    void createDelimiters() {
        Delimiters delimiters = DelimitersFactory.createDelimiters("1,2:3");

        assertThat(delimiters.equals(new Delimiters())).isTrue();

        Delimiters delimiters2 = DelimitersFactory.createDelimiters("//;\n1;2;3");

        assertThat(delimiters2.equals(new Delimiters(";"))).isTrue();
    }
}
