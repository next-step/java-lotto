package stringpluscalculator;

public class Separator {

    private final String separator;

    public Separator(String input) {
        validate(input);
        this.separator = input;
    }

    public String getSeparator() {
        return this.separator;
    }

    public void validate(String input) {
        if(!isCharacter(input)){
            throw new IllegalArgumentException("올바른 구분자가 아닙니다.");
        }
    }

    private boolean isCharacter(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
