package entities;

public class Food {
	String name;
	String characteristic;
	Food nextFoodYes = null;
	Food nextFoodNo = null;
	
	public Food() {
		this.name = "";
		this.characteristic = "";
		this.nextFoodYes = null;
		this.nextFoodNo = null;
	}
	
	public Food(String name, String caracteristic, Food nextFoodNo){
		this.name = name;
		this.characteristic = caracteristic;
		this.nextFoodYes = null;
		this.nextFoodNo = nextFoodNo;
	}
	
	
	public Food(String name, String caracteristic){
		this.name = name;
		this.characteristic = caracteristic;
		this.nextFoodYes = null;
		this.nextFoodNo = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getCharacteristic() {
		return this.characteristic;
	}
	

	public void setNextFoodYes(Food newFood) {
		this.nextFoodYes = newFood;
	}
	
	public Food getNextFoodYes() {
		return nextFoodYes;
	}
	
	public void setNextFoodNo(Food newFood) {
		this.nextFoodNo = newFood;
	}
	
	public Food getNextFoodNo() {
		return nextFoodNo;
	}

}
