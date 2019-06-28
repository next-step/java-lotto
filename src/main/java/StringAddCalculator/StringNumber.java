package StringAddCalculator;
import java.util.Objects;

public class StringNumber {

    private int number;

    public StringNumber(String stringNumber) {
        int number = convertInt(stringNumber);

        verifyNegative(number);
        this.number = number;
    }

    public StringNumber add(StringNumber addedStringNumber) {
        int added = addedStringNumber.toInt();
        return new StringNumber(Integer.toString(this.number + added));
    }

    public int toInt() {
        return this.number;
    }

    private int convertInt(String number) {
        return Integer.parseInt(number);
    }

    private void verifyNegative(int checked){
        if(checked < 0) throw new IllegalArgumentException("음수는 사용할 수 없습니다.");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringNumber that = (StringNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
