package lotto;

public class Formula {
    private final FilterCustomDelimiter filterCustomDelimiter;
    private final FilterOperands filterOperands;

    public Formula(FilterCustomDelimiter filterCustomDelimiter, FilterOperands filterOperands) {
        this.filterCustomDelimiter = filterCustomDelimiter;
        this.filterOperands = filterOperands;
    }

    public Integer calculate(String rawFormula) {
        return -1;
    }
}
