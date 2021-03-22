/*
 * Delimiter를 포장하는 클래스
 * */

package Calculator;

import java.util.Objects;

public class Delimiter {

    public static String DEFAULT_DELIMETER = ",|:";

    private String delimter;

    public Delimiter() {
        this.delimter = DEFAULT_DELIMETER;
    }

    public Delimiter(String delimter) {
        this.delimter = delimter;
    }

    public String getDelimter() {
        return delimter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(delimter, delimiter.delimter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimter);
    }
}
