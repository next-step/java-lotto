package calculator.domain;

public enum CharacterType {
    NUMBER("숫자", 10),
    DELIMETER("구분자", 20),
    NOT_DEFINED("정의되지 않음", 99);

    private String name;
    private int code;

    CharacterType(String name, int code){
        this.name = name;
        this.code = code;
    }
}
