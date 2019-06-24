package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DelimitersTest {
    Delimiters delimiters;
    Delimiter commaDelimiter;
    Delimiter colonDelimiter;

    @BeforeEach
    void setUp() {
        delimiters = new Delimiters();
        commaDelimiter = new Delimiter(",");
        colonDelimiter = new Delimiter(":");
    }

    @Test
    @DisplayName("기본 생성자는 ',' 및 ':' 를 갖고있다")
    void constructor() {
        assertThat(delimiters.getDelimiters()).contains(commaDelimiter, colonDelimiter);
    }

    @Test
    @DisplayName("생성자를 추가 할 수 있다")
    void addDelimiter() {
        Delimiters newDelimiters = delimiters.addDelimiter("-");
        Delimiter newDelimiter = new Delimiter("-");
        assertThat(newDelimiters.getDelimiters()).contains(commaDelimiter, colonDelimiter, newDelimiter);
    }

    @Test
    @DisplayName("구분자로 이루어진 regex 스트링을 반환한다")
    void getDelimitersRegexString() {
        assertThat(delimiters.getDelimitersRegexString()).isEqualTo(",|:");
    }
}
