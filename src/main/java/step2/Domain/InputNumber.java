package step2.Domain;

public class InputNumber {

    private static final String DEFAULT_DELIMITER = ",| ,";
    private String[] numbers;

    public InputNumber(String number){
        this.numbers = number.split(DEFAULT_DELIMITER);
        if(numbers.length != 6){
            throw new IllegalArgumentException("로또 번호는 6개 입력해주시기 바랍니다");
        }
    }

    public String[] numbers() {
        return numbers;
    }
}
