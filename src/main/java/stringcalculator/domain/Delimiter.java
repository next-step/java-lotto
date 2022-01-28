package stringcalculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Delimiter {

    private final String delimiter;

    private Delimiter(String delimiter) {
        //TODO 구분자는 숫자가 아님.
        validateIsNumber(delimiter);
        this.delimiter = delimiter;
    }

    public static List<Delimiter> of(List<String> delimiter){
        return delimiter.stream()
            .map(Delimiter::new)
            .collect(Collectors.toList());
    }

    private void validateIsNumber(String delimiter) {
        if(validateFirstIsNumber(delimiter) || validateLastIsNumber(delimiter)){
            throw new IllegalArgumentException("구분자의 시작과 끝은 숫자일 수 없습니다.");
        }
    }

    private boolean validateFirstIsNumber(String delimiter) {
        return Character.isDigit(delimiter.charAt(0));
    }

    private boolean validateLastIsNumber(String delimiter) {
        return Character.isDigit(delimiter.charAt(delimiter.length() - 1));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(delimiter, delimiter1.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(delimiter);
    }


}
