package calculator;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
 * 1. Error와 Exception차이 2. try catch finally 무엇인가 3. 문자열을 수식으로 변환 방법 - sysout "1+1" -> 1+1 => 2
 * 
 * 연산자 게임 
 * 1. 연산게임을 시작하기전 연산기호 (*, -, +, /) 중 한가지를 입력받는다 
 * 2. 랜덤으로 생성된 0~9와 입력받은 연산기호를 이용해 10번의 문제를 추출한다. 
 * 3. 1개 정답시 1점을 얻는다. 
 * 4. 10점(고급) , 9점(중급), 8점(초급) 결과가발표된다. 
 * 5. 총 3번을 틀린 경우 게임은 종료 되고 게임이 재 시작된다 (점수는 0점 초기화) 
 * 6. 필수 유효성 처리) 연산기호 (*, -, + /) 이 외 다른 문자를 넣은 경우 
 * 7. 필수 예외처리) - InputMismatchException (try catch finally사용)
 * - 게임이 종료 된경우 "--------------------"구분선을 표시해준다 (성공/실패/오류 모두포함)
 */

public class Calculator {

	public static void main(String[] args) {

		// Random r = new Random();
		Scanner sc = new Scanner(System.in);

		// int num1, num2; //랜덤으로 생성되는 숫자.
		double user = 0; // 유저의 풀이 답
		double ans = 0; // 찐 정답
		// String ope = ""; // 유저 연산자
		// String ope = "[|+|-|/|*|]"; // 유저 연산자
		int count = 0; // 틀린 수

		// String pwPattern =
		// "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$";

		while (true) {
			System.out.println("게임을 시작합니다.");
			if (count <= 3) { // 틀린거 3개 이전까지
				for (int i = 1; i <= 10; i++) {

					double num1 = Math.random();
					double rndNum1 = (int)(num1 * 10);
					double num2 = Math.random();
					double rndNum2 = (int)(num2 * 10);
					
					
					System.out.printf("%d.문제: %.0f ㅁ %.0f = %n", i, rndNum1, rndNum2);
					System.out.println("*, -, +, / 중 연산자를 입력하세요");
					System.out.println("연산자 : ");
					String ope = sc.next();

					// 유효성 검사
					while (true) {
						if (!(ope.matches("\\+|\\-|\\*|\\/"))) {
							System.out.println("다시 입력해주세요");
							ope = sc.next();
						} else {
							break;
						}
					}

					// ope = sc.next();
					if (ope.equals("+")) {
						ans = rndNum1 + rndNum2;
					} else if (ope.equals("-")) {
						ans = rndNum1 - rndNum2;
					} else if (ope.equals("*")) {
						ans = rndNum1 * rndNum2;
					} else if (ope.equals("/")) {
						ans = rndNum1 / rndNum2;
					}

					double ans2 = Math.round(ans * 10 / 10.0);

					// System.out.println(opeCheck);
					System.out.println("소수점이 발생할 경우, 소수점 1자리까지 작성하세요");
					System.out.println("정답 : ");

					try {
						user = sc.nextDouble();
						
					} catch (InputMismatchException e) {
						System.out.println("잘못 입력했습니다. 숫자만 입력가능합니다.");
						System.out.println("게임이 종료되었습니다.");
						System.exit(0);
					} finally {
						System.out.println("--------------------");
					}
					
					double user2 = Math.round(user * 10 / 10.0);

					
					if (user2 == ans2) {
						System.out.println("정답입니다.");

					} else {
						System.out.println("틀렸습니다.");
						count++;
					}

					user = 0;
					ans = 0;

				}

				// 계산기 게임 종료시
				if (count == 3) {
					System.out.println("--------------------");
					System.out.println("탈락하였습니다.");
					System.out.println("\n==게임이 재시작됩니다.==\n");
					count = 0;
				} else if (10 - count == 10) {
					System.out.println("--------------------");
					System.out.println("10점(고급)입니다");
					count = 0;
				} else if (10 - count == 9) {
					System.out.println("--------------------");
					System.out.println("9점(중급)입니다");
					count = 0;
				} else if (10 - count == 8) {
					System.out.println("--------------------");
					System.out.println("8점(초급)입니다");
					count = 0;
				}
			}

			System.out.println("한게임 더 하시겠습니까? (0:종료,1:재시작)");
			int restart = 0;
			try {
				restart = sc.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("--------------------");
			}

			while (!(restart == 0 || restart == 1)) {
				System.out.println("\n==0:종료 또는 1:재시작을 눌러주세요.==\n");
				System.out.println("한 게임 더 하시겠습니까?(0:종료,1:재시작)");

			}

			if (restart == 0) {
				// 게임종료
				System.out.println("\n==게임이 종료되었습니다.==\n");
				System.exit(0);

			} else if (restart == 1) {
				System.out.println("\n==게임을 재시작합니다.==\n");

			}

		}
	}
}
