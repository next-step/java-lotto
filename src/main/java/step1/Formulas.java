package step1;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formulas {
    private static final String DELIMITER = ",|:";

    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    private String[] formulas;

    public Formulas(String formulas) {
        if (Objects.isNull(formulas) || formulas.isEmpty()) {
            this.formulas = new String[0];
            return;
        }
        Matcher matcher = pattern.matcher(formulas);
        if (matcher.find()) {
            this.formulas = matcher.group(2).split(matcher.group(1));
            return;
        }
        this.formulas = formulas.split(DELIMITER);
    }

    public boolean isEmpty() {
        return formulas.length == 0;
    }

    public String[] getFormulas() {
        return formulas;
    }
}
