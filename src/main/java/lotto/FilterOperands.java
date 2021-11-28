package lotto;

import java.util.*;
import java.util.stream.Collectors;

public class FilterOperands {
    private final Set<Delimiter> basicDelimiters = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList(new Delimiter(","), new Delimiter(":")))
    );
    private final Set<String> regexDanglingMetaCharacters = new HashSet<>(Arrays.asList("*", ".", "?", "+"));

    public Collection<Operand> filter(String rawFormula) {
        return filter(rawFormula, (Delimiter) null);
    }

    public Collection<Operand> filter(String rawFormula, Delimiter delimiter) {
        final Set<Delimiter> delimiters = new HashSet<>(basicDelimiters);
        if (delimiter != null) {
            delimiters.add(escapeDanglingMetaCharacter(delimiter));
        }
        String[] splitByNewLine = rawFormula.split("\n");
        return filter(splitByNewLine[splitByNewLine.length - 1], delimiters);
    }

    private Collection<Operand> filter(String operandsWithDelimiters, Set<Delimiter> delimiters) {
        String delimiterRegexp = delimiters.stream().map(Delimiter::getValue).collect(Collectors.joining("|"));
        return Collections.unmodifiableCollection(
                Arrays.stream(operandsWithDelimiters.split(delimiterRegexp))
                        .map(Operand::new)
                        .collect(Collectors.toList())
        );
    }

    private Delimiter escapeDanglingMetaCharacter(Delimiter delimiter) {
        if (regexDanglingMetaCharacters.contains(delimiter.getValue())) {
            return new Delimiter("\\" + delimiter.getValue());
        }
        return delimiter;
    }
}
