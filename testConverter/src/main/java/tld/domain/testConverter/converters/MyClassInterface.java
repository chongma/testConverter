package tld.domain.testConverter.converters;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tld.domain.testConverter.entities.MyClass;


public interface MyClassInterface {

	static String toString(final MyClass obj) {
		try {
			return marshall(obj);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	static MyClass fromString(final String xml) {
		try {
			return unmarshall(xml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	static MyClass unmarshall(String xml) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MyClass.class);
		Unmarshaller marshaller = jc.createUnmarshaller();
		return (MyClass) marshaller.unmarshal(new StringReader(xml));
	}

	static String marshall(MyClass additionalData) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MyClass.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		final StringWriter w = new StringWriter();
		marshaller.marshal(additionalData, w);
		String xml = w.toString();
		return xml;
	}
}
