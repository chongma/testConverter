package tld.domain.testConverter.converters;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.openjpa.jdbc.identifier.DBIdentifier;
import org.apache.openjpa.jdbc.kernel.JDBCStore;
import org.apache.openjpa.jdbc.meta.ValueMapping;
import org.apache.openjpa.jdbc.meta.strats.AbstractValueHandler;
import org.apache.openjpa.jdbc.schema.Column;
import org.apache.openjpa.jdbc.schema.ColumnIO;
import org.apache.openjpa.jdbc.sql.DBDictionary;
import org.apache.openjpa.meta.JavaTypes;

import tld.domain.testConverter.entities.MyClass;

public class MyClassValueHandler extends AbstractValueHandler {
	private static final long serialVersionUID = 1L;

	public Column[] map(ValueMapping vm, String name, ColumnIO io, boolean adapt) {
		DBDictionary dict = vm.getMappingRepository().getDBDictionary();
		DBIdentifier colName = DBIdentifier.newColumn(name, dict != null ? dict.delimitAll() : false);
		return map(vm, colName, io, adapt);
	}

	public Column[] map(ValueMapping vm, DBIdentifier name, ColumnIO io, boolean adapt) {
		Column col = new Column();
		col.setIdentifier(name);
		col.setJavaType(JavaTypes.STRING);
		col.setSize(-1);
		col.setTypeIdentifier(
				DBIdentifier.newColumnDefinition(vm.getMappingRepository().getDBDictionary().xmlTypeName));
		col.setXML(true);
		return new Column[] { col };
	}

	public Object toDataStoreValue(ValueMapping vm, Object val, JDBCStore store) {
		if (val == null)
			return null;
		if (vm.getType() == MyClass.class) {
			try {
				return marshall((MyClass) val);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		throw new IllegalStateException("only AdditionalData can be handled with this ValueHandler");
	}

	public Object toObjectValue(ValueMapping vm, Object val) {
		if (val == null)
			return null;
		if (vm.getType() == MyClass.class) {
			try {
				return unmarshall((String) val);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		throw new IllegalStateException("only AdditionalData can be handled with this ValueHandler");
	}

	private MyClass unmarshall(String xml) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MyClass.class);
		Unmarshaller marshaller = jc.createUnmarshaller();
		return (MyClass) marshaller.unmarshal(new StringReader(xml));
	}

	private String marshall(MyClass additionalData) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(MyClass.class);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
		final StringWriter w = new StringWriter();
		marshaller.marshal(additionalData, w);
		String xml = w.toString();
		return xml;
	}

}
