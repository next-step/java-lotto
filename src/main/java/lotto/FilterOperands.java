package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class FilterOperands {
    private final Set<String> basicDelimiters = Collections.unmodifiableSet(new HashSet(Arrays.asList(",", ":")));
    private final Set<String> regexDanglingMetaCharacters = new HashSet<>(Arrays.asList("*", ".", "?", "+"));

    public Collection<Integer> filter(String rawFormula) {
        return filter(rawFormula, (String) null);
    }

    public Collection<Integer> filter(String rawFormula, String delimiter) {
        final Set<String> delimiters = new HashSet(basicDelimiters);
        if (delimiter != null) {
            delimiters.add(escapeDanglingMetaCharacter(delimiter));
        }
        String[] splitedByNewLine = rawFormula.split("\n");
        return filter(splitedByNewLine[splitedByNewLine.length - 1], delimiters);
    }

    private Collection<Integer> filter(String operandsWithDelimiters, Set<String> delimiters) {
        String delimiterRegexp = String.join("|", delimiters);
        return Collections.unmodifiableCollection(
                Arrays.stream(operandsWithDelimiters.split(delimiterRegexp))
                        .map(this::castRawOperand)
                        .collect(Collectors.toList())
        );
    }

    private Integer castRawOperand(String rawOperand) {
        if (!isNumeric(rawOperand)) {
            throw new IllegalArgumentException("operand is not numeric. operand:" + rawOperand);
        }
        if (Integer.parseInt(rawOperand) < 0) {
            throw new IllegalArgumentException(("negative numeric is not allowed. operand:" + rawOperand));
        }
        return Integer.parseInt(rawOperand);
    }

    private String escapeDanglingMetaCharacter(String delimiter) {
        if (regexDanglingMetaCharacters.contains(delimiter)) {
            return "\\" + delimiter;
        }
        return delimiter;
    }

    private boolean isNumeric(String raw) {
        try {
            Integer.parseInt(raw);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
