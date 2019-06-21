package StringAddCalculator;

import java.util.Objects;

public class StringNumber {

    private final String StringNumber;
    private int intNumber;

    public StringNumber(String number) {
        this.intNumber = convertInt(number);
        this.StringNumber = number;
    }

    public StringNumber add(StringNumber addedStringNumber) {
        int added = addedStringNumber.toInt();
        return new StringNumber(Integer.toString(this.intNumber + added));
    }

    public int toInt() {
        return this.intNumber;
    }

    private int convertInt(String number) {
        return Integer.parseInt(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringNumber that = (StringNumber) o;
        return Objects.equals(StringNumber, that.StringNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StringNumber);
    }

    @Override
    public String toString() {
        return "StringNumber{" +
                "number='" + StringNumber + '\'' +
                '}';
    }
}
