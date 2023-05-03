package calculator.converter;

public interface StringConverter<T> {
    T convert(String input);
}
