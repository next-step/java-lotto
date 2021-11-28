package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class FilterOperands {
    private final Set<String> basicDelimiters = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(",", ":")));
    private final Set<String> regexDanglingMetaCharacters = new HashSet<>(Arrays.asList("*", ".", "?", "+"));

    public Collection<Operand> filter(String rawFormula) {
        return filter(rawFormula, (String) null);
    }

    public Collection<Operand> filter(String rawFormula, String delimiter) {
        final Set<String> delimiters = new HashSet<>(basicDelimiters);
        if (delimiter != null) {
            delimiters.add(escapeDanglingMetaCharacter(delimiter));
        }
        String[] splitByNewLine = rawFormula.split("\n");
        return filter(splitByNewLine[splitByNewLine.length - 1], delimiters);
    }

    private Collection<Operand> filter(String operandsWithDelimiters, Set<String> delimiters) {
        String delimiterRegexp = String.join("|", delimiters);
        return Collections.unmodifiableCollection(
                Arrays.stream(operandsWithDelimiters.split(delimiterRegexp))
                        .map(this::castRawOperand)
                        .collect(Collectors.toList())
        );
    }

    private Operand castRawOperand(String rawOperand) {
        if (!isNumeric(rawOperand)) {
            throw new IllegalArgumentException("operand is not numeric. operand:" + rawOperand);
        }

        return new Operand(Integer.parseInt(rawOperand));
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
