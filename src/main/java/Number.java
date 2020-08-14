import java.util.Optional;

public class Number {
    public final String[] numbers;

    private Number(String[] numbers) {
        this.numbers = numbers;
    }

    public static Number numbers(String[] numbers){
        return new Number(numbers);
    }
    public static Number getTokens(String input) {
        return Optional.ofNullable(ConverterFactory.ofConverter(input))
                       .map(Converter::getNumbers)
                       .orElseThrow( () -> new RuntimeException("의미있는 숫자가 아닙니다."));
    }
}
