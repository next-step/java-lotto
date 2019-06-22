package StringAddCalculator;

import java.util.Objects;

public class StringNumber {

    private int intNumber;

    public StringNumber(String number) {
        this.intNumber = convertInt(number);
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
        return intNumber == that.intNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(intNumber);
    }

    @Override
    public String toString() {
        return "StringNumber{" +
                "intNumber=" + intNumber +
                '}';
    }
}
