# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

### 문자열 덧셈 계산기 기능 목록

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열의 합을 반환
- 커스텀 구분자 지정 기능 ex) “//;\n1;2;3” -> 구분자 ";", 합: "1+2+3"
- 음수를 전달하는 경우 RuntimeException throw
- 빈 문자열 또는 null 값을 입력할 경우 0을 반환
- 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환

### 로또 기능 목록 
- 로또 번호는 1~45까지 생성 기능
- 로또 번호 그룹에서 로또 번호는 최대 6개 제한 기능
- 로또 번호 그룹에서 순서대로 정렬 기능
- 지난 주 당첨 번호와 구매한 번호의 일치 확인 기능
- 일치된 숫자 개수에 따라서 등수를 반환하는 기능
- 로또 번호 그룹과 정답 번호를 비교해서 등수별 당첨 통계 데이터를 생성한다.
- 당첨 통계 메시지 기능
- 로또 번호 자동 생성 기능
- 사용자에게 로또 번호 및 당첨 통계 메시지 출력 기능
- 2등을 판단 하는 기능
- 보너스볼 메시지 출력 기능
