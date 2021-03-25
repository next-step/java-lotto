package step2.dto;

public class LottoCreationRequestDto {

    private final int inputValue;

    private LottoCreationRequestDto(int inputValue) {
        this.inputValue = inputValue;
    }

    public static LottoCreationRequestDto newInstance(int inputValue) {
        return new LottoCreationRequestDto(inputValue);
    }

}
