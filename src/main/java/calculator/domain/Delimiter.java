/*
 * Delimiter를 포장하는 클래스
 * */

package calculator.domain;

import java.util.Objects;

public class Delimiter {

    public static String DEFAULT_DELIMITER = ",|:";

    private String delimiter;

    public Delimiter() {
        this.delimiter = DEFAULT_DELIMITER;
    }

    public Delimiter(String delimter) {
        this.delimiter = delimter;
    }

    public String[] splitWithDelimiter(String input){
        return input.split(delimiter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimiter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }
}
