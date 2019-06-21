package StringAddCalculator;

import java.util.Objects;

public class StringNumber {


    private final String number;

    public StringNumber(String number) {
        this.number = number;
    }

    public StringNumber add(StringNumber addedNumber) {
        int numberInt = toInt();
        int addedInt = addedNumber.toInt();
        return new StringNumber(Integer.toString(numberInt + addedInt));
    }

    public int toInt() {
        return Integer.parseInt(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringNumber that = (StringNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "StringNumber{" +
                "number='" + number + '\'' +
                '}';
    }
}
