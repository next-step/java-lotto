public class ArithmeticStringConverter implements StringConverter<Integer> {

    public Integer convert(String numb) {
        return Integer.parseInt(numb);
    }
}
