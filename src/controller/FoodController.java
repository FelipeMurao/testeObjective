package controller;

import dialog.FoodMessageDialog; 
import entities.Food;

public class FoodController {
	private FoodMessageDialog _message;
	private Food _rootFood;
	private boolean _userChoice;
	private String _startCurrentFoodName;
	
	
	public FoodController(String currentFoodName, Food rootFood, FoodMessageDialog message) {
		this._rootFood = rootFood;
		this._startCurrentFoodName = currentFoodName;
		this._message = message;
	}
	
	
	public void startController() {
		do {	
			Food currentFood = _rootFood;
			String currentFoodName = _startCurrentFoodName;
			_message.startGameFoodDialog();
		
			_userChoice = _message.questionCharacteristicFoodDialog(currentFood.getCharacteristic());
		
			recursiveChoice(currentFoodName, currentFood, _userChoice);
		} while (_message.tryAgainFoodDialog());
	}
	
	
	private void recursiveChoice(String currentFoodName, Food currentFood, boolean previousUserChoice) {
		Food nextFood;
		boolean currentUserChoice;
		
		if((previousUserChoice) && (currentFood.getNextFoodYes() == null)) {
			
			_message.questionNameFoodDialog(currentFood.getName(), currentFood, previousUserChoice);
			return;
			
		} else if((previousUserChoice) && (currentFood.getNextFoodYes() != null)) {
			
			nextFood = currentFood.getNextFoodYes();
			currentUserChoice = _message.questionCharacteristicFoodDialog(nextFood.getCharacteristic());
			recursiveChoice(currentFood.getName(), nextFood, currentUserChoice);
			return;
			
		} else if((previousUserChoice == false) && currentFood.getNextFoodNo() == null) {
			
			_message.questionNameFoodDialog(currentFoodName, currentFood, previousUserChoice);
			return;
			
		} else if((previousUserChoice == false) && (currentFood.getNextFoodNo() != null)) {
			
			nextFood = currentFood.getNextFoodNo();
			currentUserChoice = _message.questionCharacteristicFoodDialog(nextFood.getCharacteristic());
			recursiveChoice(currentFoodName, nextFood, currentUserChoice);
			return;
			
		}
	}
	
}
