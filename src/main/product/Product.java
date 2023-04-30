package main.product;

public class Product {
	private String name;
	private int id;
	private double perUnitCost;
	public Product(String name, int id, double perUnitCost) {
		this.name = name;
		this.id = id;
		this.perUnitCost = perUnitCost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPerUnitCost() {
		return perUnitCost;
	}
	public void setPerUnitCost(double perUnitCost) {
		this.perUnitCost = perUnitCost;
	}
}
