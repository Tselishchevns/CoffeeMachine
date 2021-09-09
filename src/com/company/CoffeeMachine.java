package com.company;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        boolean isPlay = true;
        CoffeeValue value = new CoffeeValue(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);

        while (isPlay) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String answer = scanner.nextLine();
            //value.printAmount();
            switch (answer) {
                case ("buy"):
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, : ");
                    int ans;
                    if (scanner.hasNextInt()) {
                        ans = scanner.nextInt();
                    }else {
                        break;
                    }
                    if (ans == 1) {
                        value.coffeeEspresso();
                        break;
                    } else if (ans == 2) {
                        value.coffeeLatte();
                        break;
                    } else if (ans == 3) {
                        value.coffeeCappuccino();
                        break;
                    } else {
                        System.out.println("really?");
                        break;
                    }
                case ("fill"):
                    value.fill();
                    break;
                case ("take"):
                    System.out.println("I gave you " + value.getSalary());
                    value.giveMoney();
                    break;
                case ("remaining"):
                    value.printAmount();
                    break;
                case ("exit"):
                    isPlay = false;
                    break;
            }
        }
    }
}
class CoffeeValue{
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cup;
    private int salary;

    public CoffeeValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        cup = scanner.nextInt();
        scanner.close();
    }

    public CoffeeValue(int water, int milk, int coffeeBeans, int cup, int salary) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cup = cup;
        this.salary = salary;
    }

    public void coffeeEspresso(){
        if (water > 250 && coffeeBeans > 16 && cup > 1) {
            water -= 250;
            coffeeBeans -= 16;
            cup -= 1;
            salary += 4;
            System.out.println("Your espresso is ready!");
        }else if (water<250){
            System.out.println("Sorry, not enough water!");
        }else if (coffeeBeans < 16){
            System.out.println("Sorry, not enough coffee beans!");
        }else if (cup < 1){
            System.out.println("Sorry, not enough cup!");
        }
        System.out.println();
    }
    public void coffeeLatte(){
        if (water > 350 && coffeeBeans > 20 && milk > 75 && cup > 1) {
            water -= 350;
            coffeeBeans -= 20;
            milk -= 75;
            cup -= 1;
            salary += 7;
            System.out.println("Your latte is ready!");
        }else if (water<350){
            System.out.println("Sorry, not enough water!");
        }else if (coffeeBeans < 20){
            System.out.println("Sorry, not enough coffee beans!");
        }else if (cup < 1){
            System.out.println("Sorry, not enough cup!");
        }else if (milk<75){
            System.out.println("Sorry, not enough milk!");
        }
    }
    public void coffeeCappuccino(){
        if (water > 200 && coffeeBeans > 12 && milk > 100 && cup > 1) {
            water -= 200;
            milk -= 100;
            coffeeBeans -= 12;
            cup -= 1;
            salary += 6;
            System.out.println("Your cappuccino is ready!");
        }else if (water<200){
            System.out.println("Sorry, not enough water!");
        }else if (coffeeBeans < 12){
            System.out.println("Sorry, not enough coffee beans!");
        }else if (cup < 1){
            System.out.println("Sorry, not enough cup!");
        }else if (milk<100){
            System.out.println("Sorry, not enough milk!");
        }
    }

    public void printAmount(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(cup + " disposable cups");
        System.out.println("$" + salary + " of money");
        System.out.println();
    }
    public void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        addWater(scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:");
        addMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        addCoffeeBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        addCup(scanner.nextInt());
        scanner.close();
    }
    public void giveMoney(){
        salary = 0;
    }

    public void addWater(int wat) {
        water += wat;
    }

    public void addMilk(int mil) {
        milk += mil;
    }

    public void addCoffeeBeans(int coffeeBean) {
        coffeeBeans += coffeeBean;
    }

    public void addCup(int coun){
        cup += coun;
    }

    public int getSalary() {
        return salary;
    }
}