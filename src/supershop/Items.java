package supershop;

public class Items {
	private int id;
    private String Name;
    private String Price;
    private String unit;
    private float stock;
    
    public Items(int id, String name, String price, String unit, float stock)
    {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setUnit(unit);
        this.stock=stock;
    }
    
  
	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPrice() {
		return Price;
	}


	public void setPrice(String price) {
		Price = price;
	}


	public String getUnit() {
		return unit;
	}


	public void setUnit(String unit) {
		this.unit = unit;
	}
}
