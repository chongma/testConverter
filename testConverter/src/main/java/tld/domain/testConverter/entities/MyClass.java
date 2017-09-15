package tld.domain.testConverter.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyClass implements Serializable {
	private static final long serialVersionUID = 1L;

	private String body;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
