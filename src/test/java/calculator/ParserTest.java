package calculator;

import calculator.domain.Parser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.*;

public class ParserTest {

    @Test
    void 문자파싱(){
        Parser parser = new Parser();
        Queue<String> stringQueue = new LinkedList<>();

        stringQueue.add("3");
        stringQueue.add("+");
        stringQueue.add("5");

        Queue<String> expectedQueue = parser.parseString("3 + 5");
        assertThat(stringQueue).isEqualTo(expectedQueue);
    }

    @Test
    void 공백이_올수_없다(){
        Parser parser = new Parser();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            parser.parseString("");
        });
    }
}
