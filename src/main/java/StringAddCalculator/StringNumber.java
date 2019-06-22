package StringAddCalculator;
import java.util.Objects;

public class StringNumber {

    private int number;

    public StringNumber() {
    }

    public StringNumber(String number) {
        this.number = convertInt(number);
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

    @Override
    public String toString() {
        return "StringNumber{" +
                "number=" + number +
                '}';
    }
}
