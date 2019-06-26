package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InputViewTest {

    @Test
    void hello() {

        Arrays.stream("1 , 2, 4 ,5 , 6 ,7".replace(" ", "").split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()).forEach(System.out::println);
    }
}
