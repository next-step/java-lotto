package com.pollra.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * @since       2021.11.30
 * @author      pollra
 **********************************************************************************************************************/
public class Decomposer {

    private static final String COLON = ":";
    private static final String COMMA = ",";

    private static final String CUSTOM_SEPARATOR_PREFIX = "//";
    private static final String CUSTOM_SEPARATOR_SUFFIX = "\\\\n";

    private List<Separator> separators;

    public Decomposer() {
        separators = new ArrayList<>();
        separators.add(new Separator(COLON));
        separators.add(new Separator(COMMA));
    }

    public Numbers decompose(String text) {
        int customSeparatorBoundary = text.indexOf(CUSTOM_SEPARATOR_SUFFIX);
        if(0 > customSeparatorBoundary) {
            return decomposeNumbers(text, 0);
        }
        if(0 < customSeparatorBoundary) {
            int textLength = text.length();
            decomposeSeparators(text.substring(0, customSeparatorBoundary));

            customSeparatorBoundary += CUSTOM_SEPARATOR_SUFFIX.length();

            return decomposeNumbers(text.substring(customSeparatorBoundary, textLength), 0);
        }
        throw new RuntimeException("식이 올바르지 않습니다.");
    }

    private void decomposeSeparators(String text) {
        int prefixEndIndex = text.indexOf(CUSTOM_SEPARATOR_PREFIX);
        prefixEndIndex += CUSTOM_SEPARATOR_PREFIX.length();

        String customSeparatorText = text.substring(prefixEndIndex);

        separators.add(new Separator(customSeparatorText));
    }

    private Numbers decomposeNumbers(String text, int index) {
        Separator separator = separators.get(index);

        return null;
    }
}
