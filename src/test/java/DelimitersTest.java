import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimitersTest {
    @Test
    @DisplayName("기본 생성자는 ',' 및 ':' 를 갖고있다")
    void constructor() {
        Delimiters delimiters = new Delimiters();
        Delimiter commaDelimiter = new Delimiter(",");
        Delimiter colonDelimiter = new Delimiter(":");
        assertThat(delimiters.getDelimiters()).contains(commaDelimiter, colonDelimiter);
    }
}
