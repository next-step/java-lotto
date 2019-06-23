import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Delimiters {
    private List<Delimiter> delimiters;

    public Delimiters() {
        delimiters = new ArrayList<>();
        delimiters.add(new Delimiter(","));
        delimiters.add(new Delimiter(":"));
    }

    private Delimiters(List<Delimiter> delimiters, Delimiter delimiter) {
        this.delimiters = delimiters;
        this.delimiters.add(delimiter);
    }

    public Delimiters addDelimiter(String delimiterString) {
        Delimiter delimiter = new Delimiter(delimiterString);
        return new Delimiters(this.delimiters, delimiter);
    }

    public List<Delimiter> getDelimiters() {
        return Collections.unmodifiableList(delimiters);
    }
}
