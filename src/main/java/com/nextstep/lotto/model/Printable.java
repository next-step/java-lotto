package com.nextstep.lotto.model;

public interface Printable {
	String REVENUE_RATIO_STRING = "총 수익률은 %.2f 입니다.";
	String STATISTICS_HEAD_STRING = "당첨 통계";
	String NUMBER_MATCH_STRING = "%d개 일치 (%d원)- %d 개";

	void print();
}
