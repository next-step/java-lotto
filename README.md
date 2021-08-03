# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 - 자동차 경주(리팩토링) Todo-List 🎯
- [ ] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 구분하는 기능(splitWithCommaOrColon) 구현
- [ ] 커스텀 구분자로 문자열을 구분하는 기능(splitWithCustomDelimiter)의 구현
- [ ] 유효성 체크 기능의 구현
  - [ ] 분리된 문자열이 자연수인지 확인 기능(isNaturalNumber)의 구현
  - [ ] 분리된 문자열이 빈문자열 또는 null 확인 기능(isNullOrEmpty)의 구현
  - [ ] 분리된 문자열 배열의 음수를 포함 확인 기능의(containsNegativeNumber)의 구현
- [ ] 쉼표(,)나 콜론(:) 또는 커스텀 구분자로 문자열을 구분 후 이를 더하는 기능(splitAndSum)의 구현
