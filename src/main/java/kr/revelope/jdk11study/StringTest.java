package kr.revelope.jdk11study;

public class StringTest {
	/**
	 * String.trim() : 앞뒤로 공백을 제거
	 * String.strip() : [NEW] 유니코드 공백문자(ex:\u205f)를 포함하여 앞뒤로 공백을 제거
	 * String.stripLeading() : [NEW] 유니코드 공백문자(ex:\u205f)를 포함하여 앞 공백을 제거
	 * String.stripTrailing() : [NEW] 유니코드 공백문자(ex:\u205f)를 포함하여 뒤 공백을 제거
	 *
	 * String.isEmpty() : 문자열 길이가 0이면 true
	 * String.isBlank() : [NEW] 문자열 길이가 0이거나 모두 공백문자이면 true
	 *
	 * String.lines() : [NEW] 개행문자(\n)기준으로 문자열을 잘라 Stream<String>으로 반환
	 *
	 * String.repeat(int count) : [NEW] 문자열을 count만큼 반복한 문자열 반환
	 */
	public static void main(String[] args) {
		System.out.println("==============================");

		trim();

		System.out.println("==============================");

		strip();

		System.out.println("==============================");

		isEmpty();

		System.out.println("==============================");

		isBlank();

		System.out.println("==============================");

		lines();

		System.out.println("==============================");

		repeat();

		System.out.println("==============================");
	}

	private static void trim() {
		String str = " reve ";
		String trim = str.trim();

		System.out.println(String.format("trim : [%s] > [%s]", str, trim));
	}

	private static void strip() {
		String str = "\u205f reve \u205f";

		String strip = str.strip();
		System.out.println(String.format("strip : [%s] > [%s]", str, strip));

		String stripLeading = str.stripLeading();
		System.out.println(String.format("stripLeading : [%s] > [%s]", str, stripLeading));

		String stripTrailing = str.stripTrailing();
		System.out.println(String.format("stripTrailing : [%s] > [%s]", str, stripTrailing));
	}

	private static void isEmpty() {
		String str = "";
		System.out.println(String.format("isEmpty [%s] ? %b", str, str.isEmpty()));

		str = " ";
		System.out.println(String.format("isEmpty [%s] ? %b", str, str.isEmpty()));

		str = "\t";
		System.out.println(String.format("isEmpty [%s] ? %b", str, str.isEmpty()));
	}

	private static void isBlank() {
		String str = "";
		System.out.println(String.format("isBlank [%s] ? %b", str, str.isBlank()));

		str = " ";
		System.out.println(String.format("isBlank [%s] ? %b", str, str.isBlank()));

		str = "\t";
		System.out.println(String.format("isBlank [%s] ? %b", str, str.isBlank()));
	}

	private static void lines() {
		String str = "aaa\nbbb\nccc";
		System.out.println("lines : ");
		str.lines().forEach(System.out::println);
	}

	private static void repeat() {
		String str = "testMessage ";
		System.out.println(String.format("%srepeat 5 : %s", str, str.repeat(5)));
	}
}
