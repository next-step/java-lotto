package calculator.parser.converter;

public interface StringConverter<T> {
    T convert(String input);
}
