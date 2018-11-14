package lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    public void test(){
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        System.out.println(numbers.contains("1"));
    }
}