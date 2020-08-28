package application;

import controller.FoodController;
import dialog.FoodMessageDialog;
import entities.Food;

public class Main {
	
	public static void main(String[] args) {
		Food rootFood = new Food("Lasanha", "massa");
		String startCurrentFoodName = "Bolo de Chocolate";
		FoodMessageDialog foodDialog = new FoodMessageDialog();
		FoodController foodController = new FoodController(startCurrentFoodName, rootFood, foodDialog);
		
		foodController.startController();
	}
}
