package lotto.domain;


public class AnswerSheet {

    private final Lotto answerLotto;

    private final LottoNumber bonusNumber;

    public AnswerSheet(Lotto answerLotto, LottoNumber bonusNumber) {
        this.answerLotto = answerLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getAnswerLotto(){
        return this.answerLotto;
    }

    public LottoNumber getBonusNumber(){
        return this.bonusNumber;
    }
}
