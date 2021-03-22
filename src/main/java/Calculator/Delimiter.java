/*
 * Delimiter를 포장하는 클래스
 * */

package Calculator;

import java.util.Objects;

public class Delimiter {

    public static String DEFAULT_DELIMETER = ",|:";

    private String delimiter;

    public Delimiter() {
        this.delimiter = DEFAULT_DELIMETER;
    }

    public Delimiter(String delimter) {
        this.delimiter = delimter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(delimiter, delimiter.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }
}
