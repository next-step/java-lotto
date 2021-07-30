package edu.nextstep.lotto.step1.domain;

import edu.nextstep.lotto.step1.vo.Tokens;

import java.util.List;

public interface DelimiterSplitter {

    Tokens split(String text);
}
