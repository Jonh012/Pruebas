/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno103
 */
public class Cajero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        int pwd = 1235; // contraseña
        boolean flag = true; // declara una variable booleana
        double surplus = 1000;// balance

        // interfaz
        System.out.println("--------- Bienvenido al cajero automático de ICBC ---------");

        /** Limita el número de inicios de sesión **/
        for (int i = 1; i <= 3; i++) {
            System.out.println("Ingrese su NIP:");
            int inputPwd = input.nextInt();

            // verificar cuenta y contraseña
            if (inputPwd == pwd) {
                flag = true;
                break;
            } else {
                if (i <= 2) {
                    System.out.println("Su NIP incorrecta, aun tienes " + (3 - i) + " Oportunidad(es)!");
                } else {
                    System.out.println("Lo siento, ya utilizo todos los intentos posibles");
                    break;
                }
                flag = false;
            }
        }

        /** Seleccione la función después de un inicio de sesión exitoso **/
        if (flag) {
            char answer = 'y';
            while (answer == 'y') {
                System.out.println("Binevenido por favor seleccione alguna de las siguinetes acciones");
                System.out.println("1. Retirar saldo  \n 2. Depósito(Histórico de Movimientos) \n 3. Consultar saldo \n4. Salir ");
                int choice = input.nextInt();
                switch (choice) {
                case 1:
                    // Realizar una operación de retirada
                    System.out.println("---> Retirada");
                    System.out.println("Ingrese el monto del retiro:");
                    double getMoney = input.nextDouble();
                    if (getMoney > 0) {
                        if (getMoney <= surplus) {
                            if (getMoney % 100 == 0) {
                                System.out.println("¡Toma tu billete! El saldo es $ " + (surplus - getMoney));
                            } else {
                                System.out.println("Lo siento, ¡no puedo aceptar el cambio!");
                            }
                        } else {
                            System.out.println("Lo siento, el balance es insuficiente!");
                        }
                    } else {
                        System.out.println("Ingrese la cantidad correcta:");
                    }

                    break;
                case 2:
                    // realiza la operación de depósito
                    System.out.println("---> Depósito");
                    System.out.println("Organice los billetes y póngalos en el puerto de depósito:");
                    double saveMoney = input.nextDouble();
                    if (saveMoney > 0 && saveMoney <= 10000) {
                        if (saveMoney % 100 == 0) {
                            surplus += saveMoney;
                            System.out.println("¡Depósito exitoso! El saldo es ￥" + surplus);
                        } else {

                            double backMoney = saveMoney % 100;
                            surplus = saveMoney + surplus - backMoney;
                            System.out.println("¡Depósito exitoso! El saldo es ￥" + surplus);
                            System.out.println("Por favor, quita el cambio ￥" + backMoney);
                        }
                    } else if (saveMoney > 10000) {
                        System.out.println("Deposite hasta 10,000 yuanes a la vez, ¡deposite en lotes!");
                    } else {
                        System.out.println("¡El billete depositado es un billete falsificado y no es válido y es confiscado!");
                    }
                    break;
                case 3:
                    // ejecutar saldo de consulta
                    System.out.println("---> Consultar saldo");
                    System.out.println("El saldo de su tarjeta es: " + surplus);
                    break;
                case 4:
                    // realiza la operación de transferencia
                    System.out.println("---> Transferencia");
                    System.out.println("Ingrese el monto de la transferencia:");
                    double goMoney = input.nextDouble(); // cantidad de transferencia
                    if (goMoney > 0) {
                        if (goMoney <= surplus) {
                            System.out.println("¡Transferencia exitosa! El balance es ￥" + (surplus - goMoney));
                        } else {
                            System.out.println("Lo siento, ¡asegúrate de tener suficiente saldo en la tarjeta!");
                        }

                    } else {
                        System.out.println("¡Transferencia fallida! Ingrese la cantidad correcta:");
                    }
                    break;
                case 5:
                    // ejecuta la operación de salida
                    // System.out.println ("---> Salir");
                    System.out.println("¡Gracias por tu uso!");
                    return;
                default:
                    System.out.println("Lo siento, ¡la función que seleccionó es incorrecta!");
                    break;
                }// switch end
                System.out.println("¿Continuar? S / n");
                answer = input.next().charAt(0);

            } // while end
            System.out.println("¡Gracias por tu uso!");

        }

    }
    }
       /* String clave="1235";
        String pass="";
        int intentos = 0;
        while (clave.equals(pass)==false && intentos < 3) {
            pass=JOptionPane.showInputDialog("Introduce la contraseña");
            intentos++;
            if (clave.equals(pass)==false) {
                System.out.println("Contraseña incorrecta. Intente nuevamente");
            } else {
                System.out.println("Acceso Correcto");
            }
 
            if (intentos == 3 && clave.equals(pass)==false) {
                System.out.println("Por favor intente mas tarde");
            }
        }
 
    }
}*/

