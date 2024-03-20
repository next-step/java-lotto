package step1_caculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextParser {
    private static final String SPLIT_TOKEN = " ";

    public static List<String> textToStringList(String text){
        if(text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력값이 Null이거나 빈 공백입니다.");
        }

        return Arrays.stream(text.split(SPLIT_TOKEN)).collect(Collectors.toList());
    }
}
