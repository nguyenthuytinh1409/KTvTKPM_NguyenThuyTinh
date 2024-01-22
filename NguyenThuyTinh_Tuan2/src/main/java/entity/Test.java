package entity;

public class Test {
	private String name;
	private String Address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", Address=" + Address + "]";
	}
	public Test(String name, String address) {
		super();
		this.name = name;
		Address = address;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
