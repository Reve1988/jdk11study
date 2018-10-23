package kr.revelope.jdk11study;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception-in-j
 */
public class JaxbTest {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(JaxbTestModel.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		marshaller.marshal(createJaxbTestModel(), System.out);
	}

	private static JaxbTestModel createJaxbTestModel() {
		JaxbTestModel model = new JaxbTestModel();
		model.setData1("test1");
		model.setData2("test2");
		return model;
	}

	@XmlRootElement(name = "jaxbTestModel")
	private static class JaxbTestModel {
		private String data1;
		private String data2;

		public String getData1() {
			return data1;
		}

		public void setData1(String data1) {
			this.data1 = data1;
		}

		public String getData2() {
			return data2;
		}

		public void setData2(String data2) {
			this.data2 = data2;
		}
	}
}
