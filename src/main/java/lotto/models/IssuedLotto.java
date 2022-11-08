package lotto.models;

import lotto.models.enums.IssueType;

import java.util.List;

public class IssuedLotto {

    public static final int PRICE = 1000;
    private final Lotto lotto;
    private final IssueType issueType;

    private IssuedLotto(Lotto lotto, IssueType issueType) {
        this.lotto = lotto;
        this.issueType = issueType;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public static IssuedLotto of(String lottoNumbers, IssueType issueType) {
        return new IssuedLotto(Lotto.of(lottoNumbers), issueType);
    }

    public static IssuedLotto of(List<Integer> lottoNumbers, IssueType issueType) {
        return new IssuedLotto(Lotto.of(lottoNumbers), issueType);
    }


}
