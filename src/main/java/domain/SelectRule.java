package domain;

public interface SelectRule {
    boolean isSelectable();
    LottoNumbers select();
}
