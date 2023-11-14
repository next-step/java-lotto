package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TextManipulator {

        private static final String COMMA_DELIMITER = ",";
        private static final String EMPTY_TEXT_REGAX = "\\s";

        private TextManipulator() {
        }

        public static List<Integer> splitNumberTextByComma(String text) {
                String[] texts = text.replaceAll(EMPTY_TEXT_REGAX, "").split(COMMA_DELIMITER);
                return Arrays.stream(texts)
                    .mapToInt(Integer::parseInt)
                    .boxed().collect(Collectors.toList());
        }
}
