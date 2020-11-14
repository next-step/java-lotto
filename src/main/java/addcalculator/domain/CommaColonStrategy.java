package addcalculator.domain;

public class CommaColonStrategy implements SplitStrategy{

    private static final String COMMA_COLON_DELIMITER = ",|:";

    @Override
    public String[] split(String inputValue) {
        return inputValue.split(COMMA_COLON_DELIMITER);
    }
}
