package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<Integer> integerList(String integerString){
        return Arrays.stream(integerString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
