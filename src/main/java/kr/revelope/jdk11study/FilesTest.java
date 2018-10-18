package kr.revelope.jdk11study;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesTest {
	/**
	 * Files.readString() : [NEW] 파일에 들어있는 문자열을 읽어 String으로 반환
	 * Fiels.writeString() : [NEW] 문자열을 파일로 작성
	 */
	public static void main(String[] args) throws IOException {
		Resource resource = new ClassPathResource("/testfile");
		Path testfilePath = Path.of(resource.getURI());
		String str = Files.readString(testfilePath);

		System.out.println("READ ========================");
		System.out.println(str);

		Path tempFilePath = Files.createTempFile("temp", ".txt");
		Files.writeString(tempFilePath, str);

		System.out.println("WRITE ========================");
		System.out.println(Files.readString(tempFilePath));
	}
}
