package CoffeeMachine;

import java.util.Scanner;


public class CoffeeMachine {


    public static void main(String[] args) {

        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scan.next();

            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int choice = scan.nextInt();
                    buyCoffee(choice);
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    System.exit(0);
            }
        } while(true);
    }

    public static void buyCoffee(int choice) {
        switch (choice) {
            case 1:
                if (Ingredients.water >= Ingredients.espressoWater && Ingredients.coffeeBeans >=
                        Ingredients.espressoCoffeeBeans && Ingredients.cups >= 1) {
                    Ingredients.water -= Ingredients.espressoWater;
                    Ingredients.coffeeBeans -= Ingredients.espressoCoffeeBeans;
                    Ingredients.cups--;
                    Ingredients.money += Ingredients.espressoMoney;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if(Ingredients.water < Ingredients.espressoWater) {
                    System.out.println("Sorry, not enough water!");
                } else if(Ingredients.coffeeBeans < Ingredients.espressoCoffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;

            case 2:
                if (Ingredients.water >= Ingredients.latteWater && Ingredients.milk >= Ingredients.latteMilk
                        && Ingredients.coffeeBeans >= Ingredients.latteCoffeeBeans && Ingredients.cups >= 1) {
                    Ingredients.water -= Ingredients.latteWater;
                    Ingredients.milk -= Ingredients.latteMilk;
                    Ingredients.coffeeBeans -= Ingredients.latteCoffeeBeans;
                    Ingredients.cups--;
                    Ingredients.money += Ingredients.latteMoney;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if(Ingredients.water < Ingredients.latteWater) {
                    System.out.println("Sorry, not enough water!");
                } else if(Ingredients.milk < Ingredients.latteMilk) {
                        System.out.println("Sorry, not enough milk!");
                } else if(Ingredients.coffeeBeans < Ingredients.latteCoffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;

            case 3:
                if (Ingredients.water >= Ingredients.cappuccinoWater && Ingredients.milk >= Ingredients.cappuccinoMilk
                        && Ingredients.coffeeBeans >= Ingredients.cappuccinoCoffeeBeans && Ingredients.cups >= 1) {
                    Ingredients.water -= Ingredients.cappuccinoWater;
                    Ingredients.milk -= Ingredients.cappuccinoMilk;
                    Ingredients.coffeeBeans -= Ingredients.cappuccinoCoffeeBeans;
                    Ingredients.cups--;
                    Ingredients.money += Ingredients.cappuccinoMoney;
                    System.out.println("I have enough resources, making you a coffee!");
                } else if(Ingredients.water < Ingredients.cappuccinoWater) {
                    System.out.println("Sorry, not enough water!");
                } else if(Ingredients.milk < Ingredients.cappuccinoMilk) {
                    System.out.println("Sorry, not enough milk!");
                } else if(Ingredients.coffeeBeans < Ingredients.cappuccinoCoffeeBeans) {
                    System.out.println("Sorry, not enough coffee beans!");
                }
                break;
        }
    }

    public static void fill() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        Ingredients.water += scan.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        Ingredients.milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        Ingredients.coffeeBeans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        Ingredients.cups += scan.nextInt();
    }

    public static void take() {
        System.out.println("I gave you $" + Ingredients.money);
        Ingredients.money = 0;
    }

    public static void remaining() {
        System.out.println("The coffee machine has:\n" + Ingredients.water + " ml of water\n" +
                Ingredients.milk + " ml of milk\n" + Ingredients.coffeeBeans + " g of coffee beans\n"
                + Ingredients.cups + " disposable cups\n$" + Ingredients.money + " of money");
    }
}

