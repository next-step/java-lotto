package step2.Domain;

public class WinningLotto extends Lotto {

    private LottoNumber bonusBall;

    public WinningLotto(InputNumber inputNumber , LottoNumber bonusBall) {
        super(inputNumber);
        if(bonusBallDuplicateCheck(bonusBall)){
            throw new IllegalArgumentException("지난 주 당첨번호와 보너스 볼이 중복됩니다.");
        }
        this.bonusBall = bonusBall;
    }

    private boolean bonusBallDuplicateCheck(LottoNumber bonusBall){
        return this.getLottoNumberList().stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusBall));
    }

    public LottoNumber bonusBall(){
        return bonusBall;
    }
}
