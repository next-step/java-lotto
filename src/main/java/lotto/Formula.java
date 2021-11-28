package lotto;

public class Formula {
    private final FilterCustomDelimiter filterCustomDelimiter;
    private final FilterOperands filterOperands;

    public Formula(FilterCustomDelimiter filterCustomDelimiter, FilterOperands filterOperands) {
        this.filterCustomDelimiter = filterCustomDelimiter;
        this.filterOperands = filterOperands;
    }

    public Integer calculate(String rawFormula) {
        if(rawFormula == null || rawFormula.trim().isEmpty()) {
            throw new IllegalArgumentException("rawFormula is null or blank.");
        }

        return filterOperands.filter(rawFormula, filterCustomDelimiter.filter(rawFormula))
                .stream()
                .reduce(new Operand(0), Operand::add)
                .getValue();
    }
}