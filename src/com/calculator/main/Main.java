package com.calculator.main;

import com.calculator.basic.BasicCalculator;
import com.calculator.scientific.ScientificCalculator;
import com.calculator.converter.UnitConverter;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BasicCalculator basic = new BasicCalculator();
        ScientificCalculator scientific = new ScientificCalculator();
        UnitConverter converter = new UnitConverter();

        boolean continueApp = true;

        while (continueApp) {

            System.out.println("\n===== ENHANCED CALCULATOR =====");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Converter");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        basicMenu(scanner, basic);
                        break;
                    case 2:
                        scientificMenu(scanner, scientific);
                        break;
                    case 3:
                        converterMenu(scanner, converter);
                        break;
                    case 4:
                        continueApp = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    static void basicMenu(Scanner scanner, BasicCalculator basic) {
        System.out.print("Enter first number: ");
        BigDecimal a = scanner.nextBigDecimal();
        System.out.print("Enter operator (+, -, *, /): ");
        String op = scanner.next();
        System.out.print("Enter second number: ");
        BigDecimal b = scanner.nextBigDecimal();

        try {
            BigDecimal result = switch (op) {
                case "+" -> basic.add(a, b);
                case "-" -> basic.subtract(a, b);
                case "*" -> basic.multiply(a, b);
                case "/" -> basic.divide(a, b);
                default -> throw new IllegalArgumentException("Invalid operator");
            };
            System.out.println("Result: " + result);
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void scientificMenu(Scanner scanner, ScientificCalculator scientific) {
        System.out.println("1. Square Root");
        System.out.println("2. Power");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Enter number: ");
            BigDecimal a = scanner.nextBigDecimal();
            try {
                System.out.println("Result: " + scientific.squareRoot(a));
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (choice == 2) {
            System.out.print("Enter base number: ");
            BigDecimal base = scanner.nextBigDecimal();
            System.out.print("Enter exponent: ");
            int exp = scanner.nextInt();
            System.out.println("Result: " + scientific.power(base, exp));
        }
    }

    static void converterMenu(Scanner scanner, UnitConverter converter) {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.println("3. Celsius to Kelvin");
        System.out.println("4. USD to INR");
        System.out.println("5. INR to USD");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();

        if (choice <= 3) {
            System.out.print("Enter temperature: ");
            double temp = scanner.nextDouble();
            double result = switch (choice) {
                case 1 -> converter.celsiusToFahrenheit(temp);
                case 2 -> converter.fahrenheitToCelsius(temp);
                case 3 -> converter.celsiusToKelvin(temp);
                default -> 0;
            };
            System.out.println("Result: " + result);
        } else {
            System.out.print("Enter amount: ");
            BigDecimal amount = scanner.nextBigDecimal();
            BigDecimal result = switch (choice) {
                case 4 -> converter.usdToInr(amount);
                case 5 -> converter.inrToUsd(amount);
                default -> BigDecimal.ZERO;
            };
            System.out.println("Result: " + result);
        }
    }

}