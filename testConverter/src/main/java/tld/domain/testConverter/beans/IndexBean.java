package tld.domain.testConverter.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import tld.domain.testConverter.dao.MyClassDao;
import tld.domain.testConverter.entities.MyClassTable1;
import tld.domain.testConverter.entities.MyClassTable2;
import tld.domain.testConverter.entities.MyClassTable3;
import tld.domain.testConverter.entities.MyClassTable4;

@Named
@ViewScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private MyClassDao myClassDao;

	private List<MyClassTable1> myClassTable1List;
	private List<MyClassTable2> myClassTable2List;
	private List<MyClassTable3> myClassTable3List;
	private List<MyClassTable4> myClassTable4List;

	private MyClassTable1 myClassTable1;
	private MyClassTable2 myClassTable2;
	private MyClassTable3 myClassTable3;
	private MyClassTable4 myClassTable4;

	public String onload() {
		update();
		return null;
	}

	private void update() {
		myClassTable1List = myClassDao.selectTable1();
		myClassTable2List = myClassDao.selectTable2();
		myClassTable3List = myClassDao.selectTable3();
		myClassTable4List = myClassDao.selectTable4();
	}

	public String create1() {
		myClassDao.create1();
		update();
		return null;
	}

	public String create2() {
		myClassDao.create2();
		update();
		return null;
	}

	public String create3() {
		myClassDao.create3();
		update();
		return null;
	}

	public String create4() {
		myClassDao.create4();
		update();
		return null;
	}

	public String update1() {
		myClassDao.update1(myClassTable1);
		update();
		return null;
	}

	public String update2() {
		myClassDao.update2(myClassTable2);
		update();
		return null;
	}

	public String update3() {
		myClassDao.update3(myClassTable3);
		update();
		return null;
	}

	public String update4() {
		myClassDao.update4(myClassTable4);
		update();
		return null;
	}

	public List<MyClassTable1> getMyClassTable1List() {
		return myClassTable1List;
	}

	public void setMyClassTable1List(List<MyClassTable1> myClassTable1List) {
		this.myClassTable1List = myClassTable1List;
	}

	public List<MyClassTable2> getMyClassTable2List() {
		return myClassTable2List;
	}

	public void setMyClassTable2List(List<MyClassTable2> myClassTable2List) {
		this.myClassTable2List = myClassTable2List;
	}

	public List<MyClassTable3> getMyClassTable3List() {
		return myClassTable3List;
	}

	public void setMyClassTable3List(List<MyClassTable3> myClassTable3List) {
		this.myClassTable3List = myClassTable3List;
	}

	public List<MyClassTable4> getMyClassTable4List() {
		return myClassTable4List;
	}

	public void setMyClassTable4List(List<MyClassTable4> myClassTable4List) {
		this.myClassTable4List = myClassTable4List;
	}

	public MyClassTable1 getMyClassTable1() {
		return myClassTable1;
	}

	public void setMyClassTable1(MyClassTable1 myClassTable1) {
		this.myClassTable1 = myClassTable1;
	}

	public MyClassTable2 getMyClassTable2() {
		return myClassTable2;
	}

	public void setMyClassTable2(MyClassTable2 myClassTable2) {
		this.myClassTable2 = myClassTable2;
	}

	public MyClassTable3 getMyClassTable3() {
		return myClassTable3;
	}

	public void setMyClassTable3(MyClassTable3 myClassTable3) {
		this.myClassTable3 = myClassTable3;
	}

	public MyClassTable4 getMyClassTable4() {
		return myClassTable4;
	}

	public void setMyClassTable4(MyClassTable4 myClassTable4) {
		this.myClassTable4 = myClassTable4;
	}

}
