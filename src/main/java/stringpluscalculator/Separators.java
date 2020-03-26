package stringpluscalculator;

import java.util.Arrays;

public class Separators {
    private static final String SPLIT_DELIMITER = "|";
    private String[] separators = {":", ","};

    public Separators() {
    }

    public Separators(String input) {
        this.separators = new String[]{input};
    }

    public String getSplitSeparator() {
        return String.join(SPLIT_DELIMITER, this.separators);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Separators that = (Separators) o;
        return Arrays.equals(separators, that.separators);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(separators);
    }
}
