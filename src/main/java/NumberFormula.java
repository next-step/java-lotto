import java.util.Objects;

public class NumberFormula {
    private String numberFormula;
    
    public NumberFormula(String numberFormula) {
        this.numberFormula = numberFormula;
    }
    
    public String getNumberFormula() {
        return numberFormula;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberFormula that = (NumberFormula) o;
        return Objects.equals(numberFormula, that.numberFormula);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numberFormula);
    }
}
