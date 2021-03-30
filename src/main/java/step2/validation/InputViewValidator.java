package step2.validation;

public class InputViewValidator {


    public static void prizeCountValidate(int count) {
        if (count <= 0){
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
    }
}
