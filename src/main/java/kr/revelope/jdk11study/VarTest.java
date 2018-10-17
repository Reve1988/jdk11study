package kr.revelope.jdk11study;

import reactor.core.publisher.Flux;
import reactor.util.annotation.NonNull;

public class VarTest {
	/**
	 * Lambda에서 var 타입 사용이 가능
	 * i -> i * 2 === (var i) -> i * 2
	 *
	 * var를 사용해서 좋은 점 : 타입에 사용 가능한 Annotation 사용이 가능
	 */
	public static void main(String[] args) {
		Flux.just(1, 2, 3, 4, null)
				.map((@NonNull var i) -> i * 2)
				.subscribe(System.out::println);
	}
}
