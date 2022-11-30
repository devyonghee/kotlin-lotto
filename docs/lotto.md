# 로또(자동)

## 기능 요구 사항

- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [x] 로또 1장의 가격은 1000원이다.
- [x] 2등을 위해 추가 번호를 하나 더 추첨한다.
- [x] 당첨 통계에 2등도 추가해야 한다.

## 테스트 케이스

### 입력

- [x] 숫자가 아닌 문자를 입력 받았을 경우 IllegalArgumentException 오류
- [x] 최소 구매 비용이 1000이고 최소 구매 비용보다 낮은 값을 입력 받았을 경우 IllegalArgumentException 오류

### 입력 결과

- [x] 최소 구매 비용이 1000이고 입력 값이 13500일 경우 잔돈은 500을 반환
- [x] 최소 구매 비용이 1000이고 입력 값이 13500일 경우 게임 횟수 13을 반환

### 출력

- [x] 게임의 로또 번호가 1,2,3,4,5,6일 경우 [1, 2, 3, 4, 5, 6]를 반환

### 뽑기

- [x] 6개의 숫자를 뽑음

### 수익률 계산

- [x] 비율이 0.5일 경우 손해를 출력
- [x] 구매 가격이 10000이고 5등이 당첨되었다면 수익률은 0.5
- [x] 구매 가격이 3000이고 1등이 당첨되었다면 수익률은 666666.67

### 로또 게임

- [x] 로또 게임 실행 시 로또 6자리번호 생성
- [x] 로또 번호가 1,2,3,4,5,6면서 당첨번호가 1,2,3,7,8,9 보너스 번호가 10일 경우 5등
- [x] 로또 번호가 1,2,3,4,5,6면서 당첨번호가 1,2,3,4,5,9 보너스 번호가 6일 경우 2등

### 로또 게임 결과

- [x] 1등이 3번 당첨되었을 경우 당첨 횟수는 3번
- [x] 일치하는 숫자가 5개고 보너스 번호를 맞춘경우 2등 당첨
- [x] 일치하는 숫자가 3개고 보너스 번호를 맞춘경우 5등

### 상금

- [x] 일치하는 숫자가 3개일 경우 총 상금은 5000

### 검증

- [x] 숫자가 아닌 문자가 들어오거나 포함된 경우 false를 반환
- [x] 숫자 1이 기준 범위 1에서 45까지 포함된 경우 true를 반환
- [x] [1] 배열의 길이가 기준 길이 1과 같을 경우 true를 반환
- [x] 공백일 경우 false를 반환

### 당첨번호

- [x] 지난주 당첨번호 수가 로또번호 보다 적을 경우 IllegalArgumentException 오류
- [x] 지난주 당첨번호 수가 로또번호 보다 많을 경우 IllegalArgumentException 오류
- [x] 지난주 당첨번호 수가 1,2,3,4,5,6 경우 배열 [1,2,3,4,5,6]을 반환
- [x] 지난주 당첨번호 입력이 숫자와 쉼표(,)가 아닌 다른 문자로 이루어져있을 경우 IllegalArgumentException 오류
- [x] 지난주 당첨번호 입력이 공백일 경우 IllegalArgumentException 오류

### 보너스번호

- [x] 보너스번호 입력이 지난주 당첨번호에 포함되어있을 경우 이루어져있을 경우 IllegalArgumentException 오류
- [x] 보너스번호 입력이 숫자가 아닌 다른 문자로 이루어져있을 경우 IllegalArgumentException 오류
- [x] 보너스번호 입력이 공백일 경우 IllegalArgumentException 오류
- [x] 보너스번호 입력이 공백문자열일 경우 IllegalArgumentException 오류