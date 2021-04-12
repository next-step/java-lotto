package step2.utils;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static String splitStringFromList(List<Integer> lottoNumbers){
        String lottoTickets =  lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        return "["+lottoTickets+"]";
    }

    public static double splitDouble(double given){
        String temp = String.format("%.2f", given);
        return Double.parseDouble(temp);
    }
}
