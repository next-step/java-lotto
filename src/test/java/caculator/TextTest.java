package caculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextTest {

    void test(){
        String text = "1,2,3";

        List<String> list = Arrays.asList(text.split(","));

        List<Character> collect = Arrays.stream(text.split(",")).map(model -> model.charAt(0)).collect(Collectors.toUnmodifiableList());
    }
}
