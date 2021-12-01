package edu.nextstep.camp.calc.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CommandParser {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DELIMITER = ",:";
    private static final String REGEX_OR_FORMATTER = "[%s]";
    private static final String DELIMITERS = String.format(REGEX_OR_FORMATTER, DELIMITER);
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int COMMAND_GROUP = 2;

    private CommandParser() {}

    public static Collection<PositiveNumber> parse(String command) {
        if (command == null || command.isEmpty()) {
            return List.of(PositiveNumber.ZERO);
        }

        return Arrays.stream(split(command))
                .map(String::trim)
                .map(PositiveNumber::of)
                .collect(Collectors.toList());
    }

    public static String[] split(String command) {
        final Matcher matcher = PATTERN.matcher(command);
        if (!matcher.find()) {
            return command.split(DELIMITERS);
        }

        final String customDelimiter = matcher.group(CUSTOM_DELIMITER_GROUP);
        final String delimiters = String.format(REGEX_OR_FORMATTER, DELIMITER + customDelimiter);
        return matcher.group(COMMAND_GROUP)
                .split(delimiters);
    }
}
