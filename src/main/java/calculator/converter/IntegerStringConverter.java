package calculator.converter;

public class IntegerStringConverter implements calculator.converter.StringConverter<Integer> {

    public Integer convert(String numb) {
        return Integer.parseInt(numb);
    }
}
