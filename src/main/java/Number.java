public class Number {

    private final int number;

    public Number(final String number) {
        validateNumberFormat(number);
        this.number = Integer.parseInt(number);
    }

    public Number(final int number) {
        this.number = number;
    }

    public Number add(Number operand) {
        return new Number(number + operand.getNumber());
    }

    private void validateNumberFormat(final String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("올바른 숫자 포맷이 아닙니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
