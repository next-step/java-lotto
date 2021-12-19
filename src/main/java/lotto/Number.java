package lotto;

import java.util.Objects;
import java.util.regex.Pattern;

public class Number implements Comparable<Number> {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final String NOT_VALID_NUMBER_INPUT_MESSAGE = "유효한 숫자 입력이 아닙니다.";

    private final int number;

    public static final Number ONE = new Number(1);
    public static final Number TWO = new Number(2);
    public static final Number THREE = new Number(3);
    public static final Number FOUR = new Number(4);
    public static final Number FIVE = new Number(5);
    public static final Number SIX = new Number(6);
    public static final Number SEVEN = new Number(7);
    public static final Number EIGHT = new Number(8);
    public static final Number NINE = new Number(9);
    public static final Number TEN = new Number(10);
    public static final Number ELEVEN = new Number(11);
    public static final Number TWELVE = new Number(12);
    public static final Number THIRTEEN = new Number(13);
    public static final Number FOURTEEN = new Number(14);
    public static final Number FIFTEEN = new Number(15);
    public static final Number SIXTEEN = new Number(16);
    public static final Number SEVENTEEN = new Number(17);
    public static final Number EIGHTEEN = new Number(18);
    public static final Number NINETEEN = new Number(19);
    public static final Number TWENTY = new Number(20);
    public static final Number TWENTY_ONE = new Number(21);
    public static final Number TWENTY_TWO = new Number(22);
    public static final Number TWENTY_THREE = new Number(23);
    public static final Number TWENTY_FOUR = new Number(24);
    public static final Number TWENTY_FIVE = new Number(25);
    public static final Number TWENTY_SIX = new Number(26);
    public static final Number TWENTY_SEVEN = new Number(27);
    public static final Number TWENTY_EIGHT = new Number(28);
    public static final Number TWENTY_NINE = new Number(29);
    public static final Number THIRTY = new Number(30);
    public static final Number THIRTY_ONE = new Number(31);
    public static final Number THIRTY_TWO = new Number(32);
    public static final Number THIRTY_THREE = new Number(33);
    public static final Number THIRTY_FOUR = new Number(34);
    public static final Number THIRTY_FIVE = new Number(35);
    public static final Number THIRTY_SIX = new Number(36);
    public static final Number THIRTY_SEVEN = new Number(37);
    public static final Number THIRTY_EIGHT = new Number(38);
    public static final Number THIRTY_NINE = new Number(39);
    public static final Number FORTY = new Number(40);
    public static final Number FORTY_ONE = new Number(41);
    public static final Number FORTY_TWO = new Number(42);
    public static final Number FORTY_THREE = new Number(43);
    public static final Number FORTY_FOUR = new Number(44);
    public static final Number FORTY_FIVE = new Number(45);

    public Number(String number) {
        validateNumber(number);
        this.number = Integer.parseInt(number);
    }

    public Number(int number) {
        this.number = number;
    }

    private void validateNumber(String number) {
        if (!NUMBER_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException(NOT_VALID_NUMBER_INPUT_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number other = (Number) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Number o) {
        if (this.number >= o.number) {
            return 1;
        }
        return -1;
    }

}
