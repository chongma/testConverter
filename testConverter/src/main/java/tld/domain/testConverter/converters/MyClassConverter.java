package tld.domain.testConverter.converters;

import java.io.StringReader;
import java.io.StringWriter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import tld.domain.testConverter.entities.MyClass;

//@Converter
public class MyClassConverter implements AttributeConverter<MyClass, String> {

	@Override
	public String convertToDatabaseColumn(MyClass myClass) {
		try {
			return marshall(myClass);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public MyClass convertToEntityAttribute(String xml) {
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

	static String marshall(MyClass myClass) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MyClass.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		final StringWriter w = new StringWriter();
		marshaller.marshal(myClass, w);
		String xml = w.toString();
		return xml;
	}

}