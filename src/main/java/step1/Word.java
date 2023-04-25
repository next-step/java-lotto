package step1;

import java.util.Objects;

public class Word {

    private final String word;

    public Word(String word) {
        validate(word);
        this.word = word;
    }

    private void validate(String word) {
        if (Objects.isNull(word) || word.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값은 null 이거나 공백일 수 없습니다.");
        }
    }

    public String[] split(String delimiter) {
        return word.split(delimiter);
    }
}
