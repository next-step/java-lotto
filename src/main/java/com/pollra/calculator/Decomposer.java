package com.pollra.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @since       2021.11.30
 * @author      pollra
 **********************************************************************************************************************/
public class Decomposer {

    private static final int ZERO = 0;

    private static final String COLON = ":";
    private static final String COMMA = ",";

    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\\\\n";

    private final List<Separator> separators;

    public Decomposer() {
        separators = new ArrayList<>();
        separators.add(new Separator(COLON));
        separators.add(new Separator(COMMA));
    }

    public Numbers decompose(String text) {
        int customSeparatorBoundary = text.indexOf(CUSTOM_SEPARATOR_SUFFIX);
        if(ZERO > customSeparatorBoundary) {
            return decomposeNumbers(text);
        }
        if(ZERO < customSeparatorBoundary) {
            int textLength = text.length();
            String separatorText = text.substring(ZERO, customSeparatorBoundary);
            customSeparatorBoundary += CUSTOM_SEPARATOR_SUFFIX.length();
            String numbersText = text.substring(customSeparatorBoundary, textLength);

            decomposeSeparators(separatorText);
            return decomposeNumbers(numbersText);
        }
        throw new RuntimeException("식이 올바르지 않습니다.");
    }

    protected void decomposeSeparators(String text) {
        int prefixEndIndex = text.indexOf(CUSTOM_SEPARATOR_PREFIX);
        prefixEndIndex += CUSTOM_SEPARATOR_PREFIX.length();

        String customSeparatorText = text.substring(prefixEndIndex);

        separators.add(new Separator(customSeparatorText));
    }

    protected Numbers decomposeNumbers(String text) {
        List<Number> numbers = recursiveDecomposeNumber(text, ZERO);
        return new Numbers(numbers);
    }

    private List<Number> recursiveDecomposeNumber(String text, int index) {
        if(index >= separators.size()) {
            return Collections.singletonList(new Number(text));
        }
        Separator separator = separators.get(index);
        List<String> splitTexts = separator.splitOf(text);
        List<Number> numbers = new ArrayList<>();
        for (String splitText : splitTexts) {
            recursiveCondition(index, numbers, splitText);
        }
        return numbers;
    }

    private void recursiveCondition(int index, List<Number> numbers, String splitText) {
        if(Number.isNumber(splitText)) {
            numbers.add(new Number(splitText));
        }
        if(Number.notNumber(splitText)) {
            numbers.addAll(recursiveDecomposeNumber(splitText, ++index));
        }
    }
}
