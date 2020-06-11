package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Formula {
    private List<Integer> formulaNumbers = new ArrayList<>();

    public Formula(String stringFormula) {
        setFormulaNumbers(stringFormula);
        validateNumbers();
    }

    private void setFormulaNumbers(String stringFormula) {
        if (stringFormula == null || stringFormula.trim().equals("")) {
            formulaNumbers.add(0);

            return;
        }

        this.formulaNumbers = Arrays.stream(Separator.split(stringFormula)).map(Integer::parseInt).collect(Collectors.toList());
    }

    private void validateNumbers() {
        this.formulaNumbers.forEach(integer -> {
            if (integer < 0) {
                throw new RuntimeException();
            }
        });
    }

    public List<Integer> getFormulaNumbers() {
        return this.formulaNumbers;
    }
}
