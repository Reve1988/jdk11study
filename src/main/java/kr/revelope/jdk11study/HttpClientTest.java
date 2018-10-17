package kr.revelope.jdk11study;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class HttpClientTest {
	/**
	 * Java11에서 새로 생긴 HttpClient
	 * 동기호출 뿐만 아니라 비동기 호출도 사용이 가능하다.
	 *
	 * Spring의 WebClient가 더 편하다는 의견이 있다.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		usingHttpClient_usingAsync();
	}

	private static void oldStyle() throws IOException {
		URL url = new URL("https://www.naver.com");
		URLConnection connection = url.openConnection();

		try (Scanner scanner = new Scanner(connection.getInputStream())) {
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		}
	}

	private static void usingHttpClient() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://www.naver.com")).build();
		HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();

		HttpResponse<String> httpResponse = httpClient.send(httpRequest, stringBodyHandler);

		System.out.println(httpResponse.body());
	}

	private static void usingHttpClient_usingVar() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();

		var httpRequest = HttpRequest.newBuilder().uri(URI.create("https://www.naver.com")).build();
		var stringBodyHandler = HttpResponse.BodyHandlers.ofString();

		var httpResponse = httpClient.send(httpRequest, stringBodyHandler);

		System.out.println(httpResponse.body());
	}

	private static void usingHttpClient_usingAsync() throws IOException, InterruptedException {
		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("https://www.naver.com")).build();
		HttpResponse.BodyHandler<String> stringBodyHandler = HttpResponse.BodyHandlers.ofString();

		CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(httpRequest, stringBodyHandler);

		future.thenApply(HttpResponse::body)
				.thenAccept(System.out::println);

		System.out.println("print first");
		Thread.sleep(1000);
	}
}
