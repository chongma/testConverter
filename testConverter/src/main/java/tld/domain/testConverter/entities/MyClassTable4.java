package tld.domain.testConverter.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import tld.domain.testConverter.converters.MyClassConverter;

@Entity
public class MyClassTable4 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Version
	private Long version;

//	@Column(name = "body")
//	@Convert(converter = MyClassConverter.class)
//	private MyClass myClass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	protected void setVersion(Long version) {
		this.version = version;
	}

//	public MyClass getMyClass() {
//		return myClass;
//	}
//
//	public void setMyClass(MyClass myClass) {
//		this.myClass = myClass;
//	}
}
