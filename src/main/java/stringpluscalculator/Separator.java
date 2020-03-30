package stringpluscalculator;

import java.util.Objects;

public class Separator {

    private String separator;

    public Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Separator separator1 = (Separator) o;
        return Objects.equals(separator, separator1.separator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separator);
    }
}
