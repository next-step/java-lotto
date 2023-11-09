package step1.domain;

import org.apache.commons.lang3.StringUtils;
import step1.exception.EmptyStringException;
import step1.exception.InvalidRegexException;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Seperator {

    private static final String DELIMITER = " ";
    private static final String REGEX = "^[0-9]+(\\s*[-+*/]\\s*[0-9]+)*$";

    private final String[] splited;

    public Seperator(String text) {
        validate(text);
        this.splited = splited(text);
    }

    private void validate(String text) {
        validateBlank(text);
        validateRegex(text);
    }

    private static void validateBlank(String text) {
        if (StringUtils.isBlank(text)) {
            throw new EmptyStringException();
        }
    }

    private static void validateRegex(String text) {
        if (!Pattern.matches(REGEX, text)) {
            throw new InvalidRegexException();
        }
    }

    private String[] splited(String text) {
        return text.split(DELIMITER);
    }

    public LinkedList<Integer> numbers() {
        return Arrays.stream(this.splited)
            .filter(Seperator::isNumber)
            .map(Integer::parseInt)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<Operator> operators() {
        return Arrays.stream(this.splited)
            .filter(Predicate.not(Seperator::isNumber))
            .map(Operator::of)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    private static boolean isNumber(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

}
