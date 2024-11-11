import java.util.Scanner;

public class manivec {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int a, b, d, c;

        // Solicitar los valores de entrada
        System.out.print("Ingrese el primer valor (a): ");
        a = s.nextInt();
        System.out.print("Ingrese el segundo valor (b): ");
        b = s.nextInt();

        // Verificar que los valores sean válidos
        if (a > 0 && b > 0 && a >= b) {

            d = a - b;
            System.out.println("d = " + d);

            // Calcular el número de combinaciones usando la fórmula
            c = factorial(a) / (factorial(b) * factorial(d));
            System.out.println("Hay: " + c + " posibles combinaciones");

            // Mostrar las combinaciones posibles
            int[] elementos = new int[a];
            for (int i = 0; i < a; i++) {
                elementos[i] = i + 1;  // Llenar el array con los números del 1 al 'a'
            }

            // Generar las combinaciones (de b elementos)
            System.out.println("Las combinaciones posibles son:");
            mostrarCombinaciones(elementos, b, new int[b], 0, 0);
        } else {
            System.out.println("Los valores deben ser mayores a 0 y a debe ser mayor o igual que b.");
        }
    }

    // Función para calcular el factorial
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Función para mostrar las combinaciones
    public static void mostrarCombinaciones(int[] elementos, int b, int[] combinacion, int index, int start) {
        // Si la combinación tiene el tamaño 'b', la mostramos
        if (index == b) {
            for (int i = 0; i < b; i++) {
                System.out.print(combinacion[i] + " ");
            }
            System.out.println();
            return;
        }

        // Recursivamente generar combinaciones
        for (int i = start; i < elementos.length; i++) {
            combinacion[index] = elementos[i];
            mostrarCombinaciones(elementos, b, combinacion, index + 1, i + 1);
        }
    }
}