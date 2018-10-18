package kr.revelope.jdk11study;

import java.util.Arrays;
import java.util.List;

public class CollectionTest {
	/**
	 * Collection에서 Array로 변경하기 위한 toArray()함수 추가
	 */
	public static void main(String[] args) {
		List<String> stringList = List.of("testa", "testb", "testc");
		Object[] objects = stringList.toArray();
		System.out.println(Arrays.toString(objects));

		String[] strings1 = stringList.toArray(new String[0]);
		System.out.println(Arrays.toString(strings1));

		String[] strings2 = stringList.toArray(String[]::new);
		System.out.println(Arrays.toString(strings2));
	}
}
