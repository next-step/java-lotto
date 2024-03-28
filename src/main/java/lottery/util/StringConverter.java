package lottery.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringConverter {

    public static Set<Integer> convertToIntegerSet(String input){
        return Arrays.stream(splitWithCommaSpace(input))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private static String[] splitWithCommaSpace(String input){
        return input.split(", ");
    }
}
