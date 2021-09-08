package domain;

import java.util.Objects;

public class Account {

	private Integer account;

	public Account(Integer account) {
		this.account = account;
	}

	public Integer lottoCountByUnit(Integer unit) {
		return this.account / unit;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account1 = (Account) o;
		return Objects.equals(account, account1.account);
	}

	@Override
	public int hashCode() {
		return Objects.hash(account);
	}
}
