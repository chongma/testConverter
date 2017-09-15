package tld.domain.testConverter.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.apache.openjpa.persistence.Externalizer;
import org.apache.openjpa.persistence.Factory;

@Entity
public class MyClassTable2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Version
	private Long version;

	@Column(name = "body")
	@Externalizer("tld.domain.testConverter.converters.MyClassInterface.toString")
	@Factory("tld.domain.testConverter.converters.MyClassInterface.fromString")
	private MyClass myClass;

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

	public MyClass getMyClass() {
		return myClass;
	}

	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}
}
