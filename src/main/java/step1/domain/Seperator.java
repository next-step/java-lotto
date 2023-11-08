package step1.domain;

import step1.exception.EmptyStringException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Seperator {

    private static final String DELIMITER = " ";

    private final String[] splited;

    public Seperator(String text) {
        validate(text);
        this.splited = splited(text);
    }

    private void validate(String text) {
        if (text == null || text.isEmpty()) {
            throw new EmptyStringException();
        }
    }

    private String[] splited(String text) {
        return text.split(DELIMITER);
    }

    public List<Integer> numbers() {
        return Arrays.stream(this.splited)
            .filter(Seperator::isNumber)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static boolean isNumber(String text) {
        return text.chars().allMatch(Character::isDigit);
    }

    public List<Operator> operators() {
        return Arrays.stream(splited)
            .filter(Predicate.not(Seperator::isNumber))
            .map(Operator::of)
            .collect(Collectors.toList());
    }

}
